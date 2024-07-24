package com.geometry;

public class Rectangle implements Shape{
    private double sideA;
    private double sideB;
    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }
    @Override
    public double getArea() {
        return sideA * sideB;
    }
    @Override
    public double getPerimeter() {
        return (sideA + sideB) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Shape)) {
            return false;
        }
        Shape shape = (Shape) o;
        return shape.getArea() == this.getArea();
    }
    @Override
    public int hashCode() {
        return 0;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
}
