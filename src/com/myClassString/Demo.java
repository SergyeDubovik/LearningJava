package com.myClassString;

public class Demo {
    public static void main(String[] args) {
        MyString str = new MyString("It will rain soon, ");
        MyString str2 = new MyString("Jim said");
        MyString str3 = new MyString("Jim said");
        MyString str5 = new MyString("   ");
        System.out.println(str3.equals(str2));
        System.out.println(str3 == str2);

    }
}
