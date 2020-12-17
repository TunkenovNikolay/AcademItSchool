package ru.academits.tunkenov.temperature.view;

import ru.academits.tunkenov.temperature.model.TemperatureConverter;

import javax.swing.*;
import java.awt.*;

public class DesktopView implements View {
    private final TemperatureConverter temperatureConverter;
    private int selectedRadioButton;

    public DesktopView(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(600, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);

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

            JLabel kelvinTemperatureLabel = new JLabel();
            kelvinTemperatureLabel.setFont(celsiusLabel.getFont().deriveFont(20.0f));
            resultPanel.add(kelvinTemperatureLabel);

            JRadioButton celsiusToKelvin = new JRadioButton("Перевод температуры из Цельсии в Кельвин.", true);
            radioButtonPanel.add(celsiusToKelvin);
            celsiusToKelvin.addActionListener(e -> selectedRadioButton = 1);

            JRadioButton celsiusToFahrenheit = new JRadioButton("Перевод температуры из Цельсии в Фаренгейт.");
            radioButtonPanel.add(celsiusToFahrenheit);
            celsiusToFahrenheit.addActionListener(e -> selectedRadioButton = 2);

            JRadioButton fahrenheitToCelsius = new JRadioButton("Перевод температуры из Фаренгейт в Цельсии.");
            radioButtonPanel.add(fahrenheitToCelsius);
            fahrenheitToCelsius.addActionListener(e -> selectedRadioButton = 3);

            JRadioButton fahrenheitToKelvin = new JRadioButton("Перевод температуры из Фаренгейт в Кельвин.");
            radioButtonPanel.add(fahrenheitToKelvin);
            fahrenheitToKelvin.addActionListener(e -> selectedRadioButton = 4);

            JRadioButton kelvinToCelsius = new JRadioButton("Перевод температуры из Кельвин в Цельсии.");
            radioButtonPanel.add(kelvinToCelsius);
            kelvinToCelsius.addActionListener(e -> selectedRadioButton = 5);

            JRadioButton kelvinToFahrenheit = new JRadioButton("Перевод температуры из Кельвин в Фарнгейт.");
            radioButtonPanel.add(kelvinToFahrenheit);
            kelvinToFahrenheit.addActionListener(e -> selectedRadioButton = 6);

            ButtonGroup group = new ButtonGroup();
            group.add(celsiusToKelvin);
            group.add(celsiusToFahrenheit);
            group.add(fahrenheitToCelsius);
            group.add(fahrenheitToKelvin);
            group.add(kelvinToCelsius);
            group.add(kelvinToFahrenheit);

            JButton convertButton = new JButton("Перевести температуру");
            convertButton.addActionListener(e -> {
                try {
                    double temperature = Double.parseDouble(celsiusTemperatureField.getText());

                    if (selectedRadioButton == 2) {
                        kelvinTemperatureLabel.setText("Результат из Цельсии в Фаренгейт: " + temperatureConverter.convertCelsiusToFahrenheit(temperature));
                    } else if (selectedRadioButton == 3) {
                        kelvinTemperatureLabel.setText("Результат из Фаренгейт в Цельсия: " + temperatureConverter.convertFahrenheitToCelsius(temperature));
                    } else if (selectedRadioButton == 4) {
                        kelvinTemperatureLabel.setText("Результат из Фаренгейт в Кельвин: " + temperatureConverter.convertFahrenheitToKelvin(temperature));
                    } else if (selectedRadioButton == 5) {
                        kelvinTemperatureLabel.setText("Результат из Кельвин в Цельсии: " + temperatureConverter.convertKelvinToCelsius(temperature));
                    } else if (selectedRadioButton == 6) {
                        kelvinTemperatureLabel.setText("Результат из Кельвин в Фаренгейт: " + temperatureConverter.convertKelvinToFahrenheit(temperature));
                    } else {
                        kelvinTemperatureLabel.setText("Результат из Цельсии в Кельвин: " + temperatureConverter.convertCelsiusToKelvin(temperature));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Температура должна быть числом.");
                }
            });
            inputPanel.add(convertButton);

            frame.setVisible(true);
        });
    }
}
