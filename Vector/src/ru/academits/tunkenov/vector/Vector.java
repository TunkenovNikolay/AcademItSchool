package ru.academits.tunkenov.vector;

import java.util.Arrays;

public class Vector {
    private double[] array;

    public Vector(int n) {
        this.array = new double[n];
    }

    public Vector(Vector other) {
        this(other.array);
    }

    public Vector(double[] other) {
        double[] array = new double[other.length];

        for (int i = 0; i <= other.length - 1; i++) {
            array[i] = other[i];
        }

        this.array = array;
    }

    public Vector(int n, double[] other) {
        double[] array = new double[n];

        for (int i = 0; i <= other.length - 1; i++) {
            array[i] = other[i];
        }

        this.array = array;
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public int getSize() {
        return array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
