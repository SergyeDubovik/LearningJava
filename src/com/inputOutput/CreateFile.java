package com.inputOutput;

import java.io.*;
import java.util.Scanner;

import static testArrays.TaskArrays.printArray;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        String text = "pizza better than big mac";
        File folder = new File("new folder");
        folder.mkdir();
        File file = new File(folder, "hello.txt");

        writeToFile(text, file);
        readFromFile(file);
        sortInputArray();

    }
//        написать программу, которая умеет записывать в файл, то что я ввел с клавиатуры

    private static void writeToFile(String text, File f) throws IOException {
        try (OutputStream os = new FileOutputStream(f)) {
            os.write(text.getBytes());
        }
    }

//        написать программу, которая умеет читать с файла и печатать на экран

    private static void readFromFile(File f) throws IOException {
        try (InputStream inStr = new FileInputStream(f)) {
            LineNumberReader nr = new LineNumberReader(new InputStreamReader(inStr));
            String s = nr.readLine();
            System.out.println(s);
        }
    }

//    написать программу, котоая читает массив чисел с клавы, сортирует их и печатает

    private static void sortInputArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input array size: ");
        int size = sc.nextInt();
        System.out.println("input " + size + " numbers below:");
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println("Sorted array: ");
        int tmp;
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if(numbers[j] > numbers[j - 1]) {
                    tmp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = tmp;
                }
            }
        }
        printArray(numbers);
    }
}
