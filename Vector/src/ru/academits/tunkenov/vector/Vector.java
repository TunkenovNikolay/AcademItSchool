package ru.academits.tunkenov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int componentsCount) {
        if (componentsCount < 1) {
            throw new IllegalArgumentException("componentsCount = " + componentsCount + ", this value < 1, " +
                    "componentsCount must be >= 1");
        }

        this.components = new double[componentsCount];
    }

    public Vector(Vector vector) {
        this(vector.components);
    }

    public Vector(double[] array) {
        if (array.length < 1) {
            throw new IllegalArgumentException("array.length = " + array.length + ", this value < 1, " +
                    "array.length must be >= 1");
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int componentsCount, double[] array) {
        if (componentsCount < 1) {
            throw new IllegalArgumentException("componentsCount = " + componentsCount + ", this value < 1, " +
                    "componentsCount must be >= 1");
        }

        components = Arrays.copyOf(array, componentsCount);
    }

    @Override
    public String toString() {
        return Arrays.toString(components).replace("[", "{").replace("]", "}");
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

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public int getSize() {
        return components.length;
    }

    public void add(Vector vector) {
        if (components.length >= vector.components.length) {
            for (int i = 0; i < vector.components.length; i++) {
                components[i] += vector.components[i];
            }
        } else {
            double[] array = Arrays.copyOf(components, vector.components.length);

            for (int i = 0; i < vector.components.length; i++) {
                array[i] += vector.components[i];
            }

            components = array;
        }
    }

    public void getSubtraction(Vector vector) {
        if (components.length >= vector.components.length) {
            for (int i = 0; i < vector.components.length; i++) {
                components[i] -= vector.components[i];
            }
        } else {
            double[] array = Arrays.copyOf(components, vector.components.length);

            for (int i = 0; i < vector.components.length; i++) {
                array[i] -= vector.components[i];
            }

            components = array;
        }
    }

    public void multiplyOnScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyOnScalar(-1);
    }

    public double getLength() {
        double vectorLength = 0;

        for (double component : components) {
            vectorLength += component * component;
        }

        return Math.sqrt(vectorLength);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("index = " + index + ", this value out of size vector, index must be > 0 and " +
                    "< " + components.length);
        }

        return components[index];
    }

    public void setComponent(int index, double component) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("index = " + index + ", this value out of size vector, index must be > 0 and " +
                    "< " + components.length);
        }

        components[index] = component;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector1Copy = new Vector(vector1);
        vector1Copy.add(vector2);
        return vector1Copy;
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        Vector vector1Copy = new Vector(vector1);
        vector1Copy.getSubtraction(vector2);
        return vector1Copy;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int minSize = Math.min(vector1.getSize(), vector2.getSize());

        for (int i = 0; i < minSize; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}
