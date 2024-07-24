package com.geometry;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        validate(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private void validate(double sideA, double sideB, double sideC) {
        double p = (sideA + sideB + sideC) / 2;
        if (p - sideA <= 0 || p - sideB <= 0 || p - sideC <= 0) {
            throw new RuntimeException("Can't create triangle");
        }
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
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
        validate(sideA, this.sideB, this.sideC);
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        validate(this.sideA, sideB, this.sideC);
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        validate(this.sideA, this.sideB, sideC);
        this.sideC = sideC;
    }
}
