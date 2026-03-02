package com.concurrency.synchronizedKeyWord;

/*
Пример показывает проблему race condition в многопоточности.

Два потока увеличивают общий счетчик counter. Операция counter++ не атомарна,
поэтому при одновременном выполнении потоками часть инкрементов может потеряться. (см. класс CounterDemo)

Использование synchronized заставляет потоки выполнять метод increment()
по очереди, что предотвращает race condition и гарантирует правильный результат.
*/

public class SynchronizedExample {
    static int counter = 0;

    public synchronized static void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}

