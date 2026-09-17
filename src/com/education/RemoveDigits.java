package com.education;

public class RemoveDigits {
    public static void main(String[] args) {
        int n = 59015509;
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0 && digit != 5) {
                result.append(digit);
            }
            n /= 10;
        }
        int res = Integer.parseInt(result.toString());
        System.out.println(res);
    }
}
