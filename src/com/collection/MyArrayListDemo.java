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
        System.out.println(fruits.remove(2));
        System.out.println(fruits);
        System.out.println(fruits.contains("cat"));
        System.out.println(fruits.contains(new String("grape")));
        System.out.println(fruits.contains(null));
    }
}
