package com.concurrency.threadsExample;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread("First thread");
        MyThread thread2 = new MyThread("Second thread");

        thread.start();
        thread2.start();
    }
}
