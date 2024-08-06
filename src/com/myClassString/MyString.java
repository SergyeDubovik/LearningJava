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
