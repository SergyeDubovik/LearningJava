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
        if (this.x > a.x) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHigher(Point other) {
        if (this.y > other.y) {
            return true;
        } else {
            return false;
        }
    }

    public double distance(Point c) {       // не статический метод (метод обьекта)
        double length = 0;
        length = Math.sqrt(Math.pow(c.x - this.x, 2) + Math.pow(c.y - this.y, 2));

        return length;
    }


}
