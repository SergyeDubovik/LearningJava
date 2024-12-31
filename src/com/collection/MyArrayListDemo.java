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
        fruits.add(null);

        List<String> sweets = new MyArrayList();
        sweets.add("cat");
        sweets.add("grape");
        sweets.add("melon");

//        fruits.addAll(0, sweets);
        sweets.addAll(fruits);
        System.out.println(sweets);
        System.out.println(fruits);
        System.out.println(fruits.indexOf("cat"));
        System.out.println(fruits.lastIndexOf("melon"));
        System.out.println(fruits.indexOf(null));
        System.out.println(fruits.subList(1, 5));


    }
}
