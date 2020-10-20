package ru.academits.tunkenov.shapes;

import java.util.Arrays;
import java.util.Comparator;

public class FindingShape {
    public static Comparator<Shape> AreaComparator = new Comparator<Shape>() {

        @Override
        public int compare(Shape o1, Shape o2) {
            return (int) (o1.getArea() - o2.getArea());
        }
    };

    public static void ShapeMaxArea(Shape[] shapesArray) {
        Arrays.sort(shapesArray, AreaComparator);
        System.out.println("Фигура с максимальной площадью: " + shapesArray[shapesArray.length - 1]);
    }

    public static Comparator<Shape> PerimeterComparator = new Comparator<Shape>() {

        @Override
        public int compare(Shape o1, Shape o2) {
            return (int) (o1.getPerimeter() - o2.getPerimeter());
        }
    };

    public static void ShapeSecondMaxPerimeter(Shape[] shapesArray) {
        Arrays.sort(shapesArray, PerimeterComparator);
        System.out.println("Фигура со вторым максимальным периметром: " + shapesArray[shapesArray.length - 2]);
    }
}
