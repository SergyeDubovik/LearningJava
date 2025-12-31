package com.inputOutput;

import java.io.*;
import java.util.Scanner;

import static testArrays.TaskArrays.bubbleSort;
import static testArrays.TaskArrays.printArray;

public class CreateFile {

    public static void main(String[] args) throws IOException {
        String text = "pizza better than big mac";

        // Create a directory
        File folder = new File("new folder");
        folder.mkdir();

        // Create a file inside the directory
        File file = new File(folder, "hello.txt");

        writeToFile(text, file);
        readFromFile(file);
        sortInputArray();
    }

    // Write text to a file
    // (task: write a program that can save keyboard input to a file)
    private static void writeToFile(String text, File f) throws IOException {
        try (OutputStream os = new FileOutputStream(f)) {
            os.write(text.getBytes());
        }
    }

    // Read text from a file and print it to the console
    private static void readFromFile(File f) throws IOException {
        try (InputStream inStr = new FileInputStream(f)) {
            LineNumberReader nr = new LineNumberReader(new InputStreamReader(inStr));
            String s = nr.readLine();
            System.out.println(s);
        }
    }

    // Read an array of numbers from the keyboard,
    // sort it, and print the result
    private static void sortInputArray() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input array size:");
        int size = sc.nextInt();

        System.out.println("Input " + size + " numbers:");
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("Sorted array:");
        bubbleSort(numbers);
        printArray(numbers);
    }
}
