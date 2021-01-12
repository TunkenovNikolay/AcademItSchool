package ru.academits.tunkenov.temperature.model.scales;

public class FahrenheitScale implements TemperatureScale {
    private final String name;

    public FahrenheitScale(String name) {
        this.name = name;
    }

    @Override
    public double convertToCelsius(double currentTemperature) {
        return (currentTemperature - 32) * 5 / 9;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return (celsiusTemperature * 9 / 5) + 32;
    }

    @Override
    public String getName() {
        return name;
    }
}
