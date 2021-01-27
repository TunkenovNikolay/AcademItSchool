package ru.academits.tunkenov.temperature.view;

import ru.academits.tunkenov.temperature.model.TemperatureConverter;
import ru.academits.tunkenov.temperature.model.scales.TemperatureScale;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

            List<TemperatureScale> scalesList = converter.getScalesList();

            String[] scalesNames = new String[scalesList.size()];

            for (int i = 0; i < scalesList.size(); i++) {
                scalesNames[i] = scalesList.get(i).getName();
            }

            JLabel sourceScale = new JLabel("Исходная шкала:");
            radioButtonPanel.add(sourceScale);

            JLabel resultScale = new JLabel("Результирующая шкала:");
            radioButtonPanel.add(resultScale);

            JComboBox<String> inputComboBox = new JComboBox<>(scalesNames);
            radioButtonPanel.add(inputComboBox);

            JComboBox<String> outputComboBox = new JComboBox<>(scalesNames);
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
