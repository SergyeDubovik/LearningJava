package com.epamTasks.beginner.figures;

public class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;

    Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return Math.abs((a.getX() * (b.getY() - c.getY())) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2.0;
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point leftPoint = a;
        if (b.getX() < leftPoint.getX()) {
            leftPoint = b;
        }
        if ((c.getX() < leftPoint.getX())) {
            leftPoint = c;
        }
        return leftPoint;
    }
}
