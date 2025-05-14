package com.epamTasks;

import java.util.Scanner;

public class QuadraticEquation {
    /*
        implement a program to solve quadratic equations.

        For the given quadratic equation coefficients (ax2 + bx + c = 0), return one or two roots of the equation
        if there is any in the set of real numbers.

        Input value is given via System.in. Output value must be printed to System.out.

        Output format is:

        x1 x2 (two roots in any order separated by space) if there are two roots,
        x1 (just the value of the root) if there is the only root,
        no roots (just a string value "no roots") if there is no root.
        The 'a' parameter is guaranteed to be not zero.

        Examples:
        Input: 1, -2, 1
        Output: 1

        Input: 2, 5, -3
        Output: -3 0.5

        Input: 2, 2, 2
        Output: no roots
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();
        double discriminant = b * b - (4 * a * c);
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } else {
            System.out.println("no roots");
        }
    }
}
