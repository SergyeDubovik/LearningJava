package com.education;

import java.util.Locale;
import java.util.Scanner;

public class InfiniteSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // dot - separator
        System.out.println("input eps: ");
        double epsilon = sc.nextDouble();

        double sum = 0.0;
        double power4 = 1.0;
        double power5 = 1.0;
        while (true) {
            double term = 1.0 / (power4 + power5); // calc current
            sum += term;
            if (term < epsilon) {         // break when the term is small
                break;
            }
            power4 *= 4; // next power of 4
            power5 *= 5; // next power of 5
        }
        System.out.println("sum = " + sum);
    }
}
