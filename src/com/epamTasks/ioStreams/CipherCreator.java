package com.epamTasks.ioStreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CipherCreator {
    private CipherCreator() {
    }

    public static StringBuilder cipherText(File input) {
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(input);
             TransformerInputStream tis = new TransformerInputStream(fis)) {
            int ch;
            while ((ch = tis.read()) != -1) {
                if (ch == '\n') {
                    if (word.length() > 0) {
                        sb.append(word).append('\n');
                        word.setLength(0);
                    }
                } else if (ch == '\r') {
                    sb.append(word).append('\n');
                    word.setLength(0);
                    tis.mark(1);
                    int next = tis.read();
                    if (next != '\n' && next != -1) {
                        tis.reset();
                    }
                } else {
                    word.append((char) ch);
                }
            }
            if (word.length() > 0) {
                sb.append(word);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sb;
    }

}
