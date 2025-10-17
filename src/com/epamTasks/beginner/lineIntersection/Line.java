package com.epamTasks.beginner.lineIntersection;

public class Line {
    final int k;
    final int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if (this.k == other.k) {
            if (other.b == this.b) {
                return null;
            } else {
                return null;
            }
        }
        int x = (other.b - this.b) / (this.k - other.k);
        int y = this.k * x + this.b;
        return new Point(x, y);
    }

}
