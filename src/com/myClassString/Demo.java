package com.myClassString;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("It will rain soon");
        System.out.println(str.length());
        System.out.println(str.charAt(8));
        System.out.println(str.subSequence(2, 10));
    }
}
