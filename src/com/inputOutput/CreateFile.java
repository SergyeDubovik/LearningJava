package com.inputOutput;

import java.io.*;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        String text = "pizza better than big mac";

        writeToFile(text);
        readFromFile();

    }
//        написать программу, которая умеет записывать в файл, то что я ввел с клавиатуры

    private static void writeToFile(String text) throws IOException {
        File file = new File("newFileHere/note.txt");
        System.out.println(file.getAbsolutePath());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(text.getBytes());
        }
    }

//        написать программу, которая умеет читать с файла и печатать на экран


    private static void readFromFile() throws IOException {
        File newFile = new File("newFileHere/note.txt");
        System.out.println(newFile.getAbsolutePath());
        try (InputStream inStr = new FileInputStream(newFile)) {
            LineNumberReader nr = new LineNumberReader(new InputStreamReader(inStr));
            String s = nr.readLine();
            System.out.println(s);
        }
    }

}
