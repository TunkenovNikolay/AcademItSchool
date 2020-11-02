package ru.academits.tunkenov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorComponents;

    public Vector(int countComponents) {
        if (countComponents < 1) {
            throw new IllegalArgumentException("countComponents = " + countComponents + ", this value < 1, " +
                    "countComponents must be >= 1");
        }

        this.vectorComponents = new double[countComponents];
    }

    public Vector(Vector vector) {
        this(vector.vectorComponents);
    }

    public Vector(double[] array) {
        if (array.length < 1) {
            throw new IllegalArgumentException("array.length = " + array.length + ", this value < 1, " +
                    "array.length must be >= 1");
        }

        vectorComponents = Arrays.copyOf(array, array.length);
    }

    public Vector(int countComponents, double[] array) {
        if (countComponents < 1) {
            throw new IllegalArgumentException("countComponents = " + countComponents + ", this value < 1, " +
                    "countComponents must be >= 1");
        }

        vectorComponents = Arrays.copyOf(array, countComponents);
    }

    @Override
    public String toString() {
        return Arrays.toString(vectorComponents).replace("[", "{").replace("]", "}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        return Arrays.equals(vectorComponents, vector.vectorComponents);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vectorComponents);
    }

    public int getSize() {
        return vectorComponents.length;
    }

    public void add(Vector vector) {
        if (vectorComponents.length == vector.vectorComponents.length) {
            for (int i = 0; i < vectorComponents.length; i++) {
                vectorComponents[i] += vector.vectorComponents[i];
            }
        } else {
            double[] array = Arrays.copyOf(vectorComponents, Math.max(vectorComponents.length, vector.vectorComponents.length));
            for (int i = 0; i < array.length; i++) {
                array[i] += vector.vectorComponents[i];
            }

            vectorComponents = array;
        }
    }

    public void subtract(Vector vector) {
        if (vectorComponents.length == vector.vectorComponents.length) {
            for (int i = 0; i < vectorComponents.length; i++) {
                vectorComponents[i] -= vector.vectorComponents[i];
            }
        } else {
            double[] array = Arrays.copyOf(vectorComponents, Math.max(vectorComponents.length, vector.vectorComponents.length));
            for (int i = 0; i < array.length; i++) {
                array[i] -= vector.vectorComponents[i];
            }

            vectorComponents = array;
        }
    }

    public void multiplyOnScalar(double scalar) {
        for (int i = 0; i < vectorComponents.length; i++) {
            vectorComponents[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyOnScalar(-1);
    }

    public double getLength() {
        double vectorLength = vectorComponents[0];
        for (int i = 0; i < vectorComponents.length - 1; i++) {
            vectorLength += Math.abs(vectorComponents[i] - vectorComponents[i + 1]);
        }

        return vectorLength;
    }

    public double getComponent(int index) {
        if (index < 0 || index >= vectorComponents.length) {
            throw new ArrayIndexOutOfBoundsException("index = " + index + ", this value out of size vector, index must be  > 0 and " +
                    "< " + vectorComponents.length);
        }

        return vectorComponents[index];
    }

    public void setComponent(int index, double component) {
        if (index < 0 || index >= vectorComponents.length) {
            throw new ArrayIndexOutOfBoundsException("index = " + index + ", this value out of size vector, index must be  > 0 and " +
                    "< " + vectorComponents.length);
        }

        vectorComponents[index] = component;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector3 = new Vector(vector1);
        vector3.add(vector2);
        return vector3;
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        Vector vector3 = new Vector(vector1);
        vector3.subtract(vector2);
        return vector3;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarMultiplication = 0;
        int minSize = Math.min(vector1.getSize(), vector2.getSize());

        for (int i = 0; i < minSize; i++) {
            scalarMultiplication += vector1.vectorComponents[i] * vector2.vectorComponents[i];
        }

        return scalarMultiplication;
    }
}
