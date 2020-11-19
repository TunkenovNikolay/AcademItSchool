package ru.academits.tunkenov.vector.test;

import ru.academits.tunkenov.vector.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        System.out.println("vector1: " + vector1);

        double[] array1 = {1, 3, 5, 7};
        Vector vector2 = new Vector(array1);
        System.out.println("vector2: " + vector2);

        Vector vector3 = new Vector(vector2);
        System.out.println("vector3: " + vector3);

        double[] array2 = {1, 5, 7, 1, 2, 4};
        Vector vector4 = new Vector(10, array2);
        System.out.println("vector4: " + vector4);

        System.out.println("hashCode vector3 = " + vector3.hashCode() + " | hashCode vector4 = " + vector4.hashCode());

        System.out.println("Размерность vector4 = " + vector4.getSize());

        vector4.add(vector3);
        System.out.println("vector4 после сложения с vector3 = " + vector4);

        vector1.subtract(vector4);
        System.out.println("vector1 после вычитания vector4 = " + vector1);

        vector1.multiplyByScalar(-5);
        System.out.println("vector1 после скалярного умножения = " + vector1);

        vector1.reverse();
        System.out.println("vector1 после разворота = " + vector1);

        System.out.println("Длина vector1 = " + vector1.getLength());

        System.out.println("4й компонент vector1 = " + vector1.getComponent(4));

        vector1.setComponent(4, 5);
        System.out.println("4й компонент vector1 после изменения = " + vector1.getComponent(4));

        Vector vector5 = Vector.sum(vector1, vector4);
        System.out.println("vector5: " + vector5);

        Vector vector6 = Vector.getSubtraction(vector1, vector4);
        System.out.println("vector6: " + vector6);

        System.out.println("Скалярное умножение vector1 * vector4 = " + Vector.getScalarProduct(vector1, vector4));

        double[] array3 = {1, 3, 5, 7, 0, -10};
        Vector vector7 = new Vector(array3);
        System.out.println("vector7: " + vector7);
        System.out.println("Длина vector7 = " + vector7.getLength());
    }
}
