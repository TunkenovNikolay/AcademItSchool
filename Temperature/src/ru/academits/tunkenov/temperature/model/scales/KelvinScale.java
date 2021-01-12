package ru.academits.tunkenov.temperature.model.scales;

public class KelvinScale implements TemperatureScale {
    private final String name;

    public KelvinScale(String name) {
        this.name = name;
    }

    @Override
    public double convertToCelsius(double currentTemperature) {
        return currentTemperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }

    @Override
    public String getName() {
        return name;
    }
}
