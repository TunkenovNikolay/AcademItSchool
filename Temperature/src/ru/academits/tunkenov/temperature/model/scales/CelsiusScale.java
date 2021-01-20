package ru.academits.tunkenov.temperature.model.scales;

public class CelsiusScale implements TemperatureScale {
    private final static String name = "Градусы Цельсия";

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
