package ru.academits.tunkenov.temperature.model;

public class TemperatureConverter implements Converter {
    String[] comboBoxStrings = {
            "Перевод температуры из Цельсии в Кельвин.",
            "Перевод температуры из Цельсии в Фаренгейт.",
            "Перевод температуры из Фаренгейт в Цельсии.",
            "Перевод температуры из Фаренгейт в Кельвин.",
            "Перевод температуры из Кельвин в Цельсии.",
            "Перевод температуры из Кельвин в Фарнгейт."
    };

    public String[] getComboBoxStrings(){
        return comboBoxStrings;
    }

    private double convertCelsiusToKelvin(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }

    private double convertCelsiusToFahrenheit(double celsiusTemperature) {
        return celsiusTemperature * 1.8 + 32;
    }

    private double convertFahrenheitToCelsius(double fahrenheitTemperature) {
        return (fahrenheitTemperature - 32) * 1.8;
    }

    private double convertKelvinToCelsius(double kelvinTemperature) {
        return kelvinTemperature - 273.15;
    }

    @Override
    public String temperatureConverter(Object object, double temperature) {
        if (object.equals("Перевод температуры из Цельсии в Кельвин.")) {
            return "Результат перевода температуры из Цельсии в Кельвин: " + convertCelsiusToKelvin(temperature);
        }
        if (object.equals("Перевод температуры из Цельсии в Фаренгейт.")) {
            return "Результат перевода температуры из Цельсии в Фаренгейт: " + convertCelsiusToFahrenheit(temperature);
        }
        if (object.equals("Перевод температуры из Фаренгейт в Цельсии.")) {
            return "Результат перевода температуры из Фаренгейт в Цельсии: " + convertFahrenheitToCelsius(temperature);
        }
        if (object.equals("Перевод температуры из Кельвин в Цельсии.")) {
            return "Результат перевода температуры из Кельвин в Цельсии: " + convertKelvinToCelsius(temperature);
        }
        if (object.equals("Перевод температуры из Кельвин в Фарнгейт.")){
            return "Результат перевода температуры из Кельвин в Фарнгейт: " + convertCelsiusToFahrenheit(convertKelvinToCelsius(temperature));
        }
        if(object.equals("Перевод температуры из Фаренгейт в Кельвин.")){
            return "Результат перевода температуры из Фаренгейт в Кельвин: " + convertCelsiusToKelvin(convertFahrenheitToCelsius(temperature));
        }

        return "Ошибка";
    }
}
