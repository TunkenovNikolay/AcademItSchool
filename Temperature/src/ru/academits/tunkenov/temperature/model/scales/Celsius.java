package ru.academits.tunkenov.temperature.model.scales;

public class Celsius implements TemperatureScales {
    @Override
    public double convertToCelsius(double currentTemperature) {
        return currentTemperature;
    }

    @Override
    public double convertCelsiusToCurrent(double celsiusTemperature) {
        return celsiusTemperature;
    }
}
