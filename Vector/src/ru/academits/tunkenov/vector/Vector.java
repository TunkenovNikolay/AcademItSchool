package ru.academits.tunkenov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        this.vector = new double[n];
    }

    public Vector(Vector other) {
        this(other.vector);
    }

    public Vector(double[] other) {
        vector = Arrays.copyOf(other, other.length);
    }

    public Vector(int n, double[] other) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        vector = Arrays.copyOf(other, n);
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector1 = (Vector) o;
        return Arrays.equals(vector, vector1.vector);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }

    public int getSize() {
        return vector.length;
    }

    public void getSum(Vector other) {
        double[] array = Arrays.copyOf(vector, Math.max(vector.length, other.getSize()));
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] += other.vector[i];
        }

        vector = array;
    }

    public void getSubtraction(Vector other) {
        double[] array = Arrays.copyOf(vector, Math.max(vector.length, other.getSize()));
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] -= other.vector[i];
        }

        vector = array;
    }

    public void getScalarMultiplication(int scalar) {
        for (int i = 0; i <= vector.length - 1; i++) {
            vector[i] *= scalar;
        }
    }

    public void reversVector() {
        for (int i = 0; i <= vector.length - 1; i++) {
            vector[i] *= -1;
        }
    }

    public double getVectorLength() {
        double vectorLength = vector[0];
        for (int i = 0; i <= vector.length - 2; i++) {
            vectorLength += Math.abs(vector[i] - vector[i + 1]);
        }

        return vectorLength;
    }

    public double getComponentToIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index must be >= 0");
        }

        return vector[index];
    }

    public void setNewComponentToIndex(int index, double component) {
        if (index < 0) {
            throw new IllegalArgumentException("index must be >= 0");
        }

        vector[index] = component;
    }

    public static Vector getSumTwoVectors(Vector vector1, Vector vector2) {
        double[] array = Arrays.copyOf(vector1.vector, Math.max(vector1.getSize(), vector2.getSize()));
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] += vector2.vector[i];
        }

        return new Vector(array);
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        double[] array = Arrays.copyOf(vector1.vector, Math.max(vector1.getSize(), vector2.getSize()));
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] -= vector2.vector[i];
        }

        return new Vector(array);
    }

    public static double getVectorsScalarMultiplication(Vector vector1, Vector vector2) {
        double scalarMultiplication = 0;
        for (int i = 0; i <= Math.min(vector1.getSize(), vector2.getSize()) - 1; i++) {
            scalarMultiplication += vector1.vector[i] * vector2.vector[i];
        }

        return scalarMultiplication;
    }
}
