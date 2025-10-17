package com.epamTasks.beginner.ioStreams.cipherCreator;

import java.io.IOException;
import java.io.InputStream;

public class TransformerInputStream extends InputStream {
    private final InputStream inputStream;

    public TransformerInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        int c;
        while ((c = inputStream.read()) != -1) {
            char ch = (char) c;
            if (ch == '\n' || ch == '\r') {
                return c;
            }
            if (Character.isLetter(ch)) {
                return shiftedLetter(ch);
            }
        }
        return -1;
    }

    private char shiftedLetter(char ch) {
        if (Character.isUpperCase(ch)) {
            return (char) ('A' + (ch - 'A' + 2) % 26);
        } else {
            return (char) ('a' + (ch - 'a' + 2) % 26);
        }
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }

}
