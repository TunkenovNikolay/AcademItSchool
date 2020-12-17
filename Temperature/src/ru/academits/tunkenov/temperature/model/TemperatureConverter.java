package ru.academits.tunkenov.temperature.model;

public class TemperatureConverter {
    public double convertCelsiusToKelvin(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }

    public double convertCelsiusToFahrenheit(double celsiusTemperature) {
        return celsiusTemperature * 1.8 + 32;
    }

    public double convertFahrenheitToCelsius(double fahrenheitTemperature) {
        return (fahrenheitTemperature - 32) * 1.8;
    }

    public double convertFahrenheitToKelvin(double fahrenheitTemperature) {
        return (fahrenheitTemperature - 32) * 1.8 + 273.15;
    }

    public double convertKelvinToCelsius(double kelvinTemperature) {
        return kelvinTemperature - 273.15;
    }

    public double convertKelvinToFahrenheit(double kelvinTemperature) {
        return (kelvinTemperature - 273.15) * 1.8 + 23;
    }
}
