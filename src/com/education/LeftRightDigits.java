package com.education;

public class LeftRightDigits {
    public static void main(String[] args) {
        int given = 1022;
        //  formula: x1022y = x * 100000 + 1022 * 10 + y
        for (int left = 1; left <= 9; left++) {
            for (int right = 0; right <= 9; right++) {
                int n = left * 100000 + given * 10 + right;
                if (n % 7 == 0 && n % 8 == 0 && n % 9 == 0) {
                    System.out.println(n);
                }
            }
        }
    }
}
