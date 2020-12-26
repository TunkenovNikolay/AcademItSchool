package ru.academits.tunkenov.temperature.view;

import ru.academits.tunkenov.temperature.model.Converter;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DesktopView implements View {
    private final Converter converter;

    public DesktopView(Converter converter) {
        this.converter = converter;
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(600, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Dimension minimumSize = new Dimension(580, 300);
            frame.setMinimumSize(minimumSize);

            JPanel inputPanel = new JPanel(new FlowLayout());
            frame.add(inputPanel, BorderLayout.NORTH);

            JPanel resultPanel = new JPanel(new FlowLayout());
            frame.add(resultPanel, BorderLayout.SOUTH);

            JPanel radioButtonPanel = new JPanel();
            radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.PAGE_AXIS));
            frame.add(radioButtonPanel);

            JLabel celsiusLabel = new JLabel("Введите температуру:");
            inputPanel.add(celsiusLabel);

            JTextField celsiusTemperatureField = new JTextField(10);
            inputPanel.add(celsiusTemperatureField);

            JLabel temperatureLabel = new JLabel();
            temperatureLabel.setFont(celsiusLabel.getFont().deriveFont(12.0f));
            resultPanel.add(temperatureLabel);

            String[] comboBoxStrings = converter.getComboBoxStrings();

            JComboBox<String> comboBox = new JComboBox<>(comboBoxStrings);
            radioButtonPanel.add(comboBox);

            JButton convertButton = new JButton("Перевести температуру");
            convertButton.addActionListener(e -> {
                try {
                    double temperature = Double.parseDouble(celsiusTemperatureField.getText());
                    temperatureLabel.setText(converter.temperatureConverter(Objects.requireNonNull(comboBox.getSelectedItem()), temperature));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Температура должна быть числом.");
                }
            });
            inputPanel.add(convertButton);

            frame.setVisible(true);
        });
    }
}
