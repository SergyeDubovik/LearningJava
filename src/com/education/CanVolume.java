package com.education;

import java.util.Scanner;

public class CanVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("cans volume V:");
        double V = sc.nextDouble();

        double radius = Math.cbrt(V / (2 * Math.PI)); // formula
        double height = 2 * radius;
        System.out.println("best radius: " + radius);
        System.out.println("best height: " + height);
    }
}
