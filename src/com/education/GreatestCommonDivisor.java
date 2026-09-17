package com.education;

import java.util.Locale;
import java.util.Scanner;
/*
    Знайти найбільший спільний дільник (НСД) двох натуральних чисел m і n,
    базуючись на властивості, що якщо m > n, то НСД(m, n) = НСД(m − n, n).
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("input m:");
        int m = sc.nextInt();
        System.out.println("input n:");
        int n = sc.nextInt();
        while (n != 0) {        // Evklid algoritm
            int rem = m % n;
            m = n;
            n = rem;
        }
        System.out.println(m);
    }
}
