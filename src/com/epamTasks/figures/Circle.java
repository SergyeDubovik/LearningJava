package com.epamTasks.figures;

public class Circle extends Figure {
    private final Point center;
    private final double radius;

    Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }


    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String pointsToString() {
        return center.toString();
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }

    @Override
    public String toString() {
        return "Circle[(" + center.getX() + "," + center.getY() + ")" + radius + "]";
    }
}
