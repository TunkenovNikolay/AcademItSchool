package ru.academits.tunkenov.temperature.model;

import ru.academits.tunkenov.temperature.model.scales.TemperatureScales;

public class TemperatureConverter implements Converter {
    @Override
    public double temperatureConverter(TemperatureScales inputTemperatureScale, TemperatureScales outputTemperatureScale, double temperature) {
        return outputTemperatureScale.convertCelsiusToCurrent(inputTemperatureScale.convertToCelsius(temperature));
    }
}
