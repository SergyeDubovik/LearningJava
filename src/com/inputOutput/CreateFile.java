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
        sortInputArray(5);

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

    private static void sortInputArray(int size) {
        Scanner sc = new Scanner(System.in);
        int[] numbs = new int[size];
        for (int i = 0; i < size; i++) {
            numbs[i] = sc.nextInt();
        }
        System.out.println("Sorted array: ");
        int tmp;
        for (int j = 1; j < size; j++) {
            for (int u = j; u > 0; u--) {
                if(numbs[u] > numbs[u - 1]) {
                    tmp = numbs[u];
                    numbs[u] = numbs[u - 1];
                    numbs[u - 1] = tmp;
                }
            }
        }
        printArray(numbs);
    }
}
