package com.myClassString;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("It will rain soon");
        MyString stringOne = new MyString("");
        System.out.println(str.indexOf('a'));
        System.out.println(str.charAt(8));
        System.out.println(str.subSequence(2, 10));

        System.out.println(stringOne.isEmpty());
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
    }
}
