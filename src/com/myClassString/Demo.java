package com.myClassString;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("Itil ill rain soon");
        System.out.println(str.indexOf('i'));
        System.out.println(str.lastIndexOf('i'));
        System.out.println(str.contains(new MyString("ill")));
    }
}
