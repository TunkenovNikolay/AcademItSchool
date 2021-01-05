package ru.academits.tunkenov.temperature.model;

import ru.academits.tunkenov.temperature.model.scales.TemperatureScales;

public interface Converter {
    double temperatureConverter(TemperatureScales inputTemperatureScale, TemperatureScales outputTemperatureScale, double temperature);
}
