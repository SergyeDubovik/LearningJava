package com.collection;

import java.util.List;

public class MyArrayListDemo {
    public static void main(String[] args) {
        List<String> fruits = new MyArrayList();
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("mandarin");
        fruits.add("grape");
        fruits.add("melon");
        System.out.println(fruits);
        System.out.println(fruits.isEmpty());
        fruits.clear();
        System.out.println(fruits);
        System.out.println(fruits.isEmpty());
        fruits.add("cherry");
        System.out.println(fruits.isEmpty());
    }
}
