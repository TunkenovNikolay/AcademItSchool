package ru.academits.tunkenov.temperature.model.scales;

public interface TemperatureScale {
    double convertToCelsius(double currentTemperature);

    double convertFromCelsius(double celsiusTemperature);

    String getName();
}
