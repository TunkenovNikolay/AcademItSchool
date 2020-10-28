package ru.academits.tunkenov.shapes.shape_test;

import ru.academits.tunkenov.shapes.*;

import java.util.Arrays;

public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shapesArray = {
                new Rectangle(10, 12),
                new Rectangle(4, 6),
                new Square(8),
                new Rectangle(3, 6),
                new Circle(6),
                new Triangle(2, 4, 5, 5, 2, 8)
        };

        Arrays.sort(shapesArray, new AreaComparator());
        System.out.println("Фигура с максимальной площадью: " + shapesArray[shapesArray.length - 1]);

        Arrays.sort(shapesArray, new PerimeterComparator());
        System.out.println("Фигура со вторым максимальным периметром: " + shapesArray[shapesArray.length - 2]);

        Square square2 = new Square(10);
        Square square3 = new Square(10);
        System.out.println(square2.hashCode() + " | " + square3.hashCode());
        System.out.println(square2.equals(square3));
    }
}
