package ru.academits.tunkenov.vector.vector_test;

import ru.academits.tunkenov.vector.Vector;

public class TEST {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        System.out.println("vector1" + vector1);

        double[] array1 = {1, 3, 5, 7};
        Vector vector2 = new Vector(array1);
        System.out.println("vector2" + vector2);

        Vector vector3 = new Vector(vector2);
        System.out.println("vector3" + vector3);

        double[] array2 = {1, 5, 7, 1, 2, 4};
        Vector vector4 = new Vector(10, array2);
        System.out.println("vector4" + vector4);

        System.out.println("hashCode vector3 = " + vector3.hashCode() + " | hashCode vector4 =" + vector4.hashCode());

        System.out.println("Разммерность vector4 = " + vector4.getSize());

        vector3.sum(vector4);
        System.out.println("vector3 после сложения с vector4 = " + vector3);

        vector1.subtraction(vector4);
        System.out.println("vector1 после вычитания vector4 = " + vector1);

        vector1.multiplicationOnScalar(-5);
        System.out.println("vector1 после скалярного умножения = " + vector1);

        vector1.reversVector();
        System.out.println("vector1 после разворота = " + vector1);

        System.out.println("Длина vector1 = " + vector1.getVectorLength());

        System.out.println("4й компонент vector1 = " + vector1.getComponentToIndex(4));

        vector1.setComponentToIndex(4, 5);
        System.out.println("4й компонент vector1 после изменения = " + vector1.getComponentToIndex(4));

        Vector vector5 = Vector.getSumTwoVectors(vector1, vector4);
        System.out.println("vector5" + vector5);

        Vector vector6 = Vector.subtraction(vector1, vector4);
        System.out.println("vector6" + vector6);

        System.out.println("Скалярное умножение vector1 * vector4 = " + Vector.getVectorsScalarMultiplication(vector1, vector4));
    }
}
