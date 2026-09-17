package com.education;

public class BinaryNumber {
    public static void main(String[] args) {
        int n = 1102;
//        System.out.println(Integer.toBinaryString(n));
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int digit = n % 2;
            sb.append(digit);
            n /= 2;
        }
        System.out.println(sb.reverse());
    }
}
