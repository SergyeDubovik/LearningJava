package com.education;

public class TowerOfHanoi {
    private static int count = 0;
    public static void main(String[] args) {
        int n = 4;
        move(n, 1, 2, 3);       // move all discs
        System.out.println("total moves - " + count);
    }

    private static void move(int n, int from, int helper, int to) {
        if (n == 0) {
            return;     // return if no discs are left
        }
        move(n-1, from, to, helper);
        System.out.println(from + "->" + to);
        count++;
        move(n-1, helper, from, to);
    }
}
