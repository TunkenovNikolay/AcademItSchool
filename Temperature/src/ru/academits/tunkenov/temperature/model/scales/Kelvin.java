package ru.academits.tunkenov.temperature.model.scales;

public class Kelvin implements TemperatureScales {
    @Override
    public double convertToCelsius(double currentTemperature) {
        return currentTemperature - 273.15;
    }

    @Override
    public double convertCelsiusToCurrent(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }
}
