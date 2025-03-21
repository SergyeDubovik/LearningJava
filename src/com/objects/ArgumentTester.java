package com.objects;

public class ArgumentTester {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String s : args) {
            sb.append(s);
            if (s.equals("hello")) {
                System.out.println(s.toUpperCase());
            } else {
                System.out.println(sb);
            }
        }
    }
}
