package ru.academits.tunkenov.temperature.model;

import ru.academits.tunkenov.temperature.model.scales.TemperatureScale;

import java.util.List;

public interface TemperatureConverter {
    double convertTemperature(int inputTemperatureScale, int outputTemperatureScale, double temperature);

    List<TemperatureScale> getScalesList();
}
