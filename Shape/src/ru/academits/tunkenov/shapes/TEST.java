package ru.academits.tunkenov.shapes;

public class TEST {
    public static void main(String[] args) {
        Shape[] shapesArray = new Shape[]{new Rectangle(10, 12), new Rectangle(4, 6), new Square(8),
                new Rectangle(3, 6), new Circle(6), new Triangle(2, 4, 5, 5, 2, 8)};

        FindingShape.ShapeMaxArea(shapesArray);
        FindingShape.ShapeSecondMaxPerimeter(shapesArray);

        Square square2 = new Square(10);
        Square square3 = new Square(12);
        System.out.println(square2.hashCode() + " | " + square3.hashCode());
    }
}
