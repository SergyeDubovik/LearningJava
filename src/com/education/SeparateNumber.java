package com.education;

public class SeparateNumber {
    public static void main(String[] args) {
        int n = 12345;
        while (n > 0) {
            int digit = n % 10;
            System.out.println(digit);
            n /= 10;
        }
    }
}
