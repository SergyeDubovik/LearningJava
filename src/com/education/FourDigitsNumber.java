package com.education;

public class FourDigitsNumber {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1000; i <= 9999; i++) {
            int digit = i % 10;
            if (digit != 0 && i % 23 == 0 && i % digit == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
