package com.collection;

import java.util.List;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList fruits = new MyArrayList();
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("mandarin");
        fruits.add("grape");
        System.out.println(fruits);
        System.out.println(fruits.get(3));
        System.out.println(fruits.size());
        System.out.println(fruits.isEmpty());

    }
}
