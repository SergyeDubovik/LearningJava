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

        List<String> sweets = new MyArrayList();
        sweets.add("cat");
        sweets.add("grape");
        sweets.add("melon");

        fruits.addAll(sweets);
        System.out.println(fruits);

    }
}
