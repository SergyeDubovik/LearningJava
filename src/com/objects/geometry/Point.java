package com.objects.geometry;

public class Point {
    public double x;
    public double y;
    public String name;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isRighter(Point a) {
        return this.x > a.x;
    }

    public boolean isHigher(Point other) {
        return this.y > other.y;
    }

    public double distance(Point c) {       // не статический метод (метод обьекта)
        double length;
        length = Math.sqrt(Math.pow(c.x - this.x, 2) + Math.pow(c.y - this.y, 2));

        return length;
    }


}
