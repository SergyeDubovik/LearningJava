package com.inputOutput;

import java.io.*;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        String text = "pizza better than big mac";
        File folder = new File("new folder");
        folder.mkdir();
        File file = new File(folder, "hello.txt");

        writeToFile(text, file);
        readFromFile(file);

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

}
