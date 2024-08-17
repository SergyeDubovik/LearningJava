package com.myClassString;

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
    public MyString(CharSequence charSequence) {
        this(charSequence.toString());
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
    public int indexOf(char ch) {
        for (int i = 0; i < data.length; i++) {
            if (ch == data[i]) {
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(char c) {
        for (int i = data.length - 1; i > 0; i--) {
            if (c == data[i]) {
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty() {
        return data.length == 0;
    }
    public MyString toLowerCase() {
        char[] chars = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= 'A' && data[i] <= 'Z') {
                chars[i] = (char) (data[i] + 32);     // 32 - difference between big and small letter in ASCII
            } else {
                chars[i] = data[i];
            }
        }
        return new MyString(chars);
    }
    public MyString toUpperCase() {
        char[] chars = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= 'a' && data[i] <= 'z') {
                chars[i] = (char) (data[i] - 32);    // 32 - difference between big and small letter in ASCII
            } else {
                chars[i] = data[i];
            }
        }
        return new MyString(chars);
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
                result[segmentIndex] = new MyString(subSequence(start, i));
                segmentIndex++;
                start = i + 1;
            }
        }

        result[segmentIndex] = new MyString(subSequence(start, data.length));
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
