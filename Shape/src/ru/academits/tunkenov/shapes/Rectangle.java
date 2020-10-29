package ru.academits.tunkenov.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = Math.abs(width);
        this.height = Math.abs(height);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return rectangle.width == width &&
                rectangle.height == height;
    }

    @Override
    public int hashCode() {
        final int prime = 33;
        int hash = 1;
        return prime * hash + Double.hashCode(width) + prime * hash + Double.hashCode(height);
    }

    @Override
    public String toString() {
        return "Rectangle {side1 = " + width + ", side2 = " + height + "}";
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }
}
