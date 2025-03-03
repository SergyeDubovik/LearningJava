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

    public boolean contains(MyString substring) {
        char[] array = substring.data;
        for (int i = 0; i < data.length - substring.length(); i++) {
            boolean found = true;
            for (int j = 0; j < substring.length(); j++) {
                if (array[j] != data[i + j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }

    public MyString concat(MyString string) {
        char[] chars = new char[data.length + string.length()];
        System.arraycopy(data, 0, chars, 0, data.length);
        System.arraycopy(string.data, 0, chars, data.length, string.length());
        return new MyString(chars);
    }

    public MyString repeat(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Number can't be negative or zero");
        }
        if (count == 1) {
            return this;
        }
        char[] chars = new char[count * data.length];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < data.length; j++) {
                chars[j + i * data.length] = data[j];
            }
        }
        return new MyString(chars);
    }

    // returns true if length() == 0
    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    public boolean isBlank() {
        for (char datum : data) {
            if (datum != ' ') {
                return false;
            }
        }
        return true;
    }

    public MyString toLowerCase() {
        char[] chars = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= 'A' && data[i] <= 'Z') {
                chars[i] = (char) (data[i] + 32);     // 32 - difference between big and small letters in ASCII
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
                chars[i] = (char) (data[i] - 32);    // 32 - difference between big and small letters in ASCII
            } else {
                chars[i] = data[i];
            }
        }
        return new MyString(chars);
    }

    public MyString[] split(char delimiter) {
        int segments = 1;
        for (char datum : data) {
            if (datum == delimiter) {
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

    @Override
    public boolean equals(Object s) {
        if (s == null) {
            return false;
        }
        if (!(s instanceof MyString)) {
            return false;
        }
        MyString other = (MyString) s;
        if (other.length() != data.length) {
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            char ch = other.data[i];
            if (data[i] != ch) {
                return false;
            }

        }
        return true;
    }

    @Override
    public int hashCode() {
        int code = 1;
        for (char datum : data) {
            code = 31 * code + datum;
        }
        return code;
    }

}
