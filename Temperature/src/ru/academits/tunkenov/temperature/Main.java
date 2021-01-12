package ru.academits.tunkenov.temperature;

import ru.academits.tunkenov.temperature.model.Converter;
import ru.academits.tunkenov.temperature.model.TemperatureConverter;
import ru.academits.tunkenov.temperature.model.scales.CelsiusScale;
import ru.academits.tunkenov.temperature.model.scales.FahrenheitScale;
import ru.academits.tunkenov.temperature.model.scales.KelvinScale;
import ru.academits.tunkenov.temperature.model.scales.TemperatureScale;
import ru.academits.tunkenov.temperature.view.DesktopView;
import ru.academits.tunkenov.temperature.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TemperatureScale> scalesList = new ArrayList<>(Arrays.asList(new CelsiusScale("Градусы Цельсия"), new FahrenheitScale("Градус Фаренгейт"), new KelvinScale("Кельвин")));

        TemperatureConverter temperatureConverter = new Converter(scalesList);

        View view = new DesktopView(temperatureConverter);

        view.start();
    }
}
