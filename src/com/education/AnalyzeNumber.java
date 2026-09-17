package com.education;

public class AnalyzeNumber {
    public static void main(String[] args) {
        int num = 123;
        int digits = 0;
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            digits++;
            temp = temp / 10;
        }
        temp = num;
        while (temp >= 10) {
            temp = temp / 10;
        }
        int firstDigit = temp;
        System.out.println("digits: " + digits);
        System.out.println("sum: " + sum);
        System.out.println("first digit: " + firstDigit);
    }
}
