package ru.academits.tunkenov.temperature.model.scales;

public interface TemperatureScales {
    double convertToCelsius(double currentTemperature);
    double convertCelsiusToCurrent(double celsiusTemperature);
}
