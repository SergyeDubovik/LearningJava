package com.benchmark;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Benchmark {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            numbers.add(random.nextInt());
        }
        benchmark(numbers);
    }

    private static void selectionSort(List<Integer> numbers) {
        int temp;
        for (int i = 0; i < numbers.size(); i++) {
            int maxElementIndex = i;
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(j) > numbers.get(maxElementIndex)) {
                    maxElementIndex = j;
                }
            }
            temp = numbers.get(i);
            numbers.set(i, numbers.get(maxElementIndex));
            numbers.set(maxElementIndex, temp);
        }
    }

    private static void quickSort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private static void benchmark(List<Integer> numbers) {
        List<Integer> copied = copy(numbers);
        long start = System.nanoTime();
        selectionSort(copied);
        long elapsedNanos = System.nanoTime() - start;
        Duration duration = Duration.ofNanos(elapsedNanos);
        System.out.println("Selection sort elapsed " + duration);

        copied = copy(numbers);
        start = System.nanoTime();
        quickSort(copied);
        elapsedNanos = System.nanoTime() - start;
        duration = Duration.ofNanos(elapsedNanos);
        System.out.println("Quick sort elapsed " + duration);
    }

    private static List<Integer> copy(List<Integer> numbers) {
        return new ArrayList<>(numbers);
    }
}
