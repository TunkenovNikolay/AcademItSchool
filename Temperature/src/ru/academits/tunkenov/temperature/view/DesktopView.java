package ru.academits.tunkenov.temperature.view;

import ru.academits.tunkenov.temperature.model.Converter;
import ru.academits.tunkenov.temperature.model.scales.TemperatureScales;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DesktopView implements View {
    private final Converter converter;
    private final HashMap<String, TemperatureScales> scalesList;

    public DesktopView(Converter converter, HashMap<String, TemperatureScales> scalesList) {
        this.converter = converter;
        this.scalesList = scalesList;
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
            radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.LINE_AXIS));
            frame.add(radioButtonPanel);

            JLabel celsiusLabel = new JLabel("Введите температуру:");
            inputPanel.add(celsiusLabel);

            JTextField celsiusTemperatureField = new JTextField(10);
            inputPanel.add(celsiusTemperatureField);

            JLabel temperatureLabel = new JLabel();
            temperatureLabel.setFont(celsiusLabel.getFont().deriveFont(12.0f));
            resultPanel.add(temperatureLabel);

            String[] scalesName = new String[scalesList.size()];
            int i = 0;

            for (Map.Entry<String, TemperatureScales> pair : scalesList.entrySet()) {
                scalesName[i] = pair.getKey();
                i++;
            }

            JComboBox<String> comboBoxInput = new JComboBox<>(scalesName);
            radioButtonPanel.add(comboBoxInput);
            comboBoxInput.setMaximumSize(new Dimension(Integer.MAX_VALUE, comboBoxInput.getMinimumSize().height));

            JComboBox<String> comboBoxOutput = new JComboBox<>(scalesName);
            radioButtonPanel.add(comboBoxOutput);
            comboBoxOutput.setMaximumSize(new Dimension(Integer.MAX_VALUE, comboBoxInput.getMinimumSize().height));

            JButton convertButton = new JButton("Перевести температуру");
            convertButton.addActionListener(e -> {
                try {
                    temperatureLabel.setText(String.valueOf(converter.temperatureConverter(
                            scalesList.get(comboBoxInput.getSelectedItem()),
                            scalesList.get(comboBoxOutput.getSelectedItem()),
                            Double.parseDouble(celsiusTemperatureField.getText()))));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Температура должна быть числом.");
                }
            });
            inputPanel.add(convertButton);

            frame.setVisible(true);
        });
    }
}
