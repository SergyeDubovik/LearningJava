package com.epamTasks.ioStreams.cipherCreator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CipherCreator {
    private CipherCreator() {
    }

    public static StringBuilder cipherText(File input) throws FileNotFoundException {
        if (input == null || !input.exists()) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(input);
             TransformerInputStream tis = new TransformerInputStream(fis)) {
            int ch;
            while ((ch = tis.read()) != -1) {
                if (ch == '\n' || ch == '\r') {
                    sb.append(word);
                    sb.append('\n');
                    word.setLength(0);
                    if (ch == '\r') {
                        tis.mark(1);
                        int next = tis.read();
                        if (next != '\n' && next != -1) {
                            tis.reset();
                        }
                    }
                } else {
                    word.append((char) ch);
                }
            }
            if (word.length() > 0) {
                sb.append(word);
            }
        } catch (IOException exception) {
            throw new IllegalArgumentException();
        }
        return sb;
    }

}
