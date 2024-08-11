package com.myClassString;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MyString implements CharSequence {
    private char[] data;
    public MyString() {
    }

    public MyString(char[] data) {
        this.data = data;
    }
    public MyString(String string) {
        this.data = string.toCharArray();
    }

    @Override
    public int length() {
        return data.length;
    }

    @Override
    public char charAt(int index) {
        return data[index];
    }
    public String toString() {
        return new String(data);
    }
    public boolean isEmpty() {
        return data.length == 0;
    }
    public MyString[] split(char delimiter) {
        int segments = 1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == delimiter) {
                segments++;
            }
        }

        MyString[] result = new MyString[segments];
        int start = 0;
        int segmentIndex = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == delimiter) {
                result[segmentIndex] = new MyString(subSequence(start, i).toString());
                segmentIndex++;
                start = i + 1;
            }
        }

        result[segmentIndex] = new MyString(subSequence(start, data.length).toString());
        return result;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end < 0 || end > data.length || start > end) {
            throw new ArrayIndexOutOfBoundsException("Incorrect value of indexes");
        }
        char[] sub = new char[end - start];
        for (int i = 0; i < sub.length; i++) {
            sub[i] = data[i + start];
        }
        return new MyString(sub);
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }
}
