package com.inputOutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        File file = new File("newFileHere/note.txt");
        System.out.println(file.getAbsolutePath());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(text.getBytes());
        }
    }
}
