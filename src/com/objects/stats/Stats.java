package com.objects.stats;

public class Stats {
    public int max;
    public int min;
    public double avg;

    public Stats(int max, int min, double avg) {
        this.max = max;
        this.min = min;
        this.avg = avg;
    }

    public void print() {
        System.out.println("Statistics: max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
    }
}
