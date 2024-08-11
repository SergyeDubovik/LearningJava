package com.myClassString;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("It will rain soon");
        MyString stringOne = new MyString("");
        System.out.println(str.length());
        System.out.println(str.charAt(8));
        System.out.println(str.subSequence(2, 10));
        MyString[] array = str.split(' ');
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println(stringOne.isEmpty());
    }
}
