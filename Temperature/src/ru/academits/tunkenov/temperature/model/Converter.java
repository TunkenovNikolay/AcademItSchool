package ru.academits.tunkenov.temperature.model;

import ru.academits.tunkenov.temperature.model.scales.TemperatureScale;

import java.util.List;

public class Converter implements TemperatureConverter {
    private final List<TemperatureScale> scalesList;

    public Converter(List<TemperatureScale> scalesList) {
        this.scalesList = scalesList;
    }

    @Override
    public double convertTemperature(int inputTemperatureScaleIndex, int outputTemperatureScaleIndex, double temperature) {
        return scalesList.get(outputTemperatureScaleIndex).convertFromCelsius(scalesList.get(inputTemperatureScaleIndex).convertToCelsius(temperature));
    }

    @Override
    public List<TemperatureScale> getScalesList() {
        return scalesList;
    }
}
