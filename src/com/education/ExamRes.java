package com.education;

public class ExamRes {
    public static void main(String[] args) {
        int total = 0;
        for (int variants = 21; variants >= 1; variants--) {
            total += variants;
        }
        System.out.println(total);
    }
}
