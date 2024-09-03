package com.myClassString;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("It will rain soon, ");
        MyString str2 = new MyString("Jim said");
        MyString str4 = new MyString("Jim said");
        MyString str3 = new MyString("Jon said");
        MyString str5 = new MyString("   ");
        System.out.println(str.contains(str5));
        System.out.println(str.indexOf('u'));
        System.out.println(str.lastIndexOf('w'));
        System.out.println(str.concat(str2));
        System.out.println(str2.repeat(2));
        System.out.println(str3.toLowerCase());
        System.out.println(str4.toUpperCase());
        System.out.println(Arrays.toString(str4.split(' ')));
        System.out.println(str3.equals(str2));
        System.out.println(str2.equals(str4));
        System.out.println(str.equals(str4));

    }
}
