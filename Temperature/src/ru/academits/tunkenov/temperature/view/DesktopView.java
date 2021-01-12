package ru.academits.tunkenov.temperature.view;

import ru.academits.tunkenov.temperature.model.TemperatureConverter;

import javax.swing.*;
import java.awt.*;

public class DesktopView implements View {
    private final TemperatureConverter converter;

    public DesktopView(TemperatureConverter converter) {
        this.converter = converter;
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(600, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Dimension minimumSize = new Dimension(450, 170);
            frame.setSize(450, 170);
            frame.setMinimumSize(minimumSize);

            JPanel inputPanel = new JPanel(new FlowLayout());
            frame.add(inputPanel, BorderLayout.NORTH);

            JPanel resultPanel = new JPanel(new FlowLayout());
            frame.add(resultPanel, BorderLayout.SOUTH);

            JPanel radioButtonPanel = new JPanel();
            GridLayout gridLayout = new GridLayout(2, 2, 5, 5);
            radioButtonPanel.setLayout(gridLayout);
            frame.add(radioButtonPanel);

            JLabel celsiusLabel = new JLabel("Введите температуру:");
            inputPanel.add(celsiusLabel);

            JTextField celsiusTemperatureField = new JTextField(10);
            inputPanel.add(celsiusTemperatureField);

            JLabel temperatureLabel = new JLabel();
            temperatureLabel.setFont(celsiusLabel.getFont().deriveFont(12.0f));
            resultPanel.add(temperatureLabel);

            String[] scalesName = new String[converter.getScalesList().size()];

            for (int i = 0; i < converter.getScalesList().size(); i++) {
                scalesName[i] = converter.getScalesList().get(i).getName();
            }

            JLabel sourceScale = new JLabel("Исходная шкала:");
            radioButtonPanel.add(sourceScale);

            JLabel sourceScale1 = new JLabel("Результирующая шкала:");
            radioButtonPanel.add(sourceScale1);

            JComboBox<String> inputComboBox = new JComboBox<>(scalesName);
            radioButtonPanel.add(inputComboBox);

            JComboBox<String> outputComboBox = new JComboBox<>(scalesName);
            radioButtonPanel.add(outputComboBox);

            JButton convertButton = new JButton("Перевести температуру");
            convertButton.addActionListener(e -> {
                try {
                    temperatureLabel.setText(String.valueOf(converter.convertTemperature(
                            inputComboBox.getSelectedIndex(),
                            outputComboBox.getSelectedIndex(),
                            Double.parseDouble(celsiusTemperatureField.getText()))));
                } catch (NumberFormatException ex) {
                    if (celsiusTemperatureField.getText().isBlank()) {
                        JOptionPane.showMessageDialog(frame, "Вы забыли ввести температуру.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Температура должна быть числом.");
                    }
                }
            });
            inputPanel.add(convertButton);

            frame.setVisible(true);
        });
    }
}
