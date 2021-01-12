package ru.academits.tunkenov.temperature.model.scales;

public class CelsiusScale implements TemperatureScale {
    private final String name;

    public CelsiusScale(String name) {
        this.name = name;
    }

    @Override
    public double convertToCelsius(double currentTemperature) {
        return currentTemperature;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return celsiusTemperature;
    }

    @Override
    public String getName() {
        return name;
    }
}
