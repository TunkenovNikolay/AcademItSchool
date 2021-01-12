package ru.academits.tunkenov.temperature.model;

import ru.academits.tunkenov.temperature.model.scales.TemperatureScale;

import java.util.List;

public class Converter implements TemperatureConverter {
    private final List<TemperatureScale> scalesList;

    public Converter(List<TemperatureScale> scalesList) {
        this.scalesList = scalesList;
    }

    @Override
    public double convertTemperature(int inputTemperatureScale, int outputTemperatureScale, double temperature) {
        return scalesList.get(outputTemperatureScale).convertFromCelsius(scalesList.get(inputTemperatureScale).convertToCelsius(temperature));
    }

    @Override
    public List<TemperatureScale> getScalesList() {
        return scalesList;
    }
}
