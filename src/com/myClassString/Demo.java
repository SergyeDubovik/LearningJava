package com.myClassString;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("It will rain soon");
        MyString srt2 = new MyString("Jim said");
        System.out.println(str.indexOf('i'));
        System.out.println(str.lastIndexOf('i'));
        System.out.println(str.concat(srt2));
    }
}
