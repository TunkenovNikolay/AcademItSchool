package ru.academits.tunkenov.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = Math.abs(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Circle circle = (Circle) o;

        return circle.radius == radius;
    }

    @Override
    public int hashCode() {
        final int prime = 32;
        int hash = 1;
        return prime * hash + Double.hashCode(radius);
    }

    @Override
    public String toString() {
        return "Circle {radius = " + radius + "}";
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
