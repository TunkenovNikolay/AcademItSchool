package ru.academits.tunkenov.temperature.model;

import ru.academits.tunkenov.temperature.model.scales.TemperatureScale;

import java.util.List;

public interface TemperatureConverter {
    double convertTemperature(int inputTemperatureScaleIndex, int outputTemperatureScaleIndex, double temperature);

    List<TemperatureScale> getScalesList();
}
