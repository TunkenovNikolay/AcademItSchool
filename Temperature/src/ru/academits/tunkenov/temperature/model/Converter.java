package ru.academits.tunkenov.temperature.model;

public interface Converter {
    String[] getComboBoxStrings();
    String temperatureConverter(Object object, double temperature);
}
