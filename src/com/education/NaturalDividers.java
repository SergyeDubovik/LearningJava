package com.education;

public class NaturalDividers {
    public static void main(String[] args) {
        int n = 25;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

}
