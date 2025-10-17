package com.epamTasks.beginner.figures;

public class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        Triangle leftTriangle = new Triangle(a, b, c);
        Triangle rightTriangle = new Triangle(a, c, d);
        return leftTriangle.area() + rightTriangle.area();
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point left = a;
        if (b.getX() < left.getX()) {
            left = b;
        }
        if (c.getX() < left.getX()) {
            left = c;
        }
        if (d.getX() < left.getX()) {
            left = d;
        }
        return left;
    }
}
