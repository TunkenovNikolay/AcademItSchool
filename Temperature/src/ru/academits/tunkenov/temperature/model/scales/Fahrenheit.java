package ru.academits.tunkenov.temperature.model.scales;

public class Fahrenheit implements TemperatureScales {
    @Override
    public double convertToCelsius(double currentTemperature) {
        return (currentTemperature - 32) * 5 / 9;
    }

    @Override
    public double convertCelsiusToCurrent(double celsiusTemperature) {
        return (celsiusTemperature * 9 / 5) + 32;
    }
}
