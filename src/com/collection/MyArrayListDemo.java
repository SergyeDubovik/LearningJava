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

        System.out.println(fruits.remove("grape"));
        System.out.println(fruits);
        fruits.add(2, "pear");
        fruits.add(4, "orange");
        System.out.println(fruits);
        fruits.set(1, "pineapple");
        System.out.println(fruits);
        fruits.set(5, "kiwi");
        System.out.println(fruits);
    }
}
