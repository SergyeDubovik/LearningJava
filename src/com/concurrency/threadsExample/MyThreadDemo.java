package com.concurrency.threadsExample;

public class MyThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread("First thread");
        MyThread thread2 = new MyThread("Second thread");

        thread.start();
        thread2.start();

        MyThread thread3 = new MyThread("cage");
        thread3.start();
        MyThread.sleep(3000);
        System.out.println("main thread interrupts another");
        thread3.interrupt();


    }
}
