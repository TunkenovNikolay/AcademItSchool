package ru.academits.tunkenov.shapes;

public class TEST {
    public static void main(String[] args) {
        Shape[] shapesArray = new Shape[] {new Rectangle(10,12), new Rectangle(4,6), new Square(8)};

        Rectangle rectangle1 = new Rectangle(10,12);
        System.out.println(rectangle1.getArea());

        Rectangle rectangle2 = new Rectangle(4, 6);
        System.out.println(rectangle2.getArea());

        Square square1 = new Square(8);
        System.out.println(square1.getArea());

        FindingShape.ShapeMaxArea(shapesArray);
        FindingShape.ShapeSecondMaxPerimeter(shapesArray);
    }
}
