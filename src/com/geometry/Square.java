package com.geometry;

public class Square implements Shape {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return side * side;
    }
    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
