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
        fruits.add(0, "123");
        fruits.add(0, "123");
        fruits.add(0, "123");
        fruits.add(0, "123");
        fruits.add(0, "123");
        fruits.add(0, "123");
        fruits.add(0, "123");

        fruits.set(4, "kiwi");
        System.out.println(fruits);
    }
}
