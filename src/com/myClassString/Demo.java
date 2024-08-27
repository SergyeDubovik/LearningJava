package com.myClassString;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("It will rain soon, ");
        MyString str2 = new MyString("Jim said");
        MyString str3 = new MyString("Jim said");
        MyString str5 = new MyString("   ");
        System.out.println(str.indexOf('i'));
        System.out.println(str.lastIndexOf('i'));
        System.out.println(str.concat(str2));
        System.out.println(str2.repeat(5));
        System.out.println(str.equals(str2));
        System.out.println(str.isBlank());
        System.out.println(str2.hashCode() == str3.hashCode());
        System.out.println(str.hashCode() == str3.hashCode());
    }
}
