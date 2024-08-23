package com.myClassString;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("It will rain soon, ");
        MyString str2 = new MyString("Jim said");
        MyString str3 = str2;
        MyString str4 = new MyString("Jim said");
        MyString str5 = new MyString("Damn");
        System.out.println(str.indexOf('i'));
        System.out.println(str.lastIndexOf('i'));
        System.out.println(str.concat(str2));
        System.out.println(str2.repeat(5));
        System.out.println(str.equals(str2));
        System.out.println(str2.equals(str3));
        System.out.println(str2 == str3);
        System.out.println(str2 == str4);
        System.out.println(str2.equals(str4));
        System.out.println(str4.isBlank());
    }
}
