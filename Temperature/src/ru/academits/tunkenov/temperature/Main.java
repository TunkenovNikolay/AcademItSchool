package ru.academits.tunkenov.temperature;

import ru.academits.tunkenov.temperature.model.Converter;
import ru.academits.tunkenov.temperature.model.TemperatureConverter;
import ru.academits.tunkenov.temperature.model.scales.Celsius;
import ru.academits.tunkenov.temperature.model.scales.Fahrenheit;
import ru.academits.tunkenov.temperature.model.scales.Kelvin;
import ru.academits.tunkenov.temperature.model.scales.TemperatureScales;
import ru.academits.tunkenov.temperature.view.DesktopView;
import ru.academits.tunkenov.temperature.view.View;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        TemperatureScales celsius = new Celsius();
        TemperatureScales fahrenheit = new Fahrenheit();
        TemperatureScales kelvin = new Kelvin();

        HashMap<String, TemperatureScales> scalesList = new HashMap<>();
        scalesList.put("Градус Цельсия", celsius);
        scalesList.put("Градус Фаренгейт", fahrenheit);
        scalesList.put("Кельвин", kelvin);

        Converter temperatureConverter = new TemperatureConverter();

        View view = new DesktopView(temperatureConverter, scalesList);

        view.start();
    }
}
