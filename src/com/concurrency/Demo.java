package com.concurrency;

public class Demo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("runnable " + i);
            }
        };
        Thread thread = new Thread(runnable);
        for (int i = 0; i < 10; i++) {
            System.out.println("before start " + i);
        }
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("after start " + i);
        }
    }
}
