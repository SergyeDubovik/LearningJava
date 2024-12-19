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
        System.out.println(fruits.containsAll(sweets));
        System.out.println("first remove: " + fruits.removeAll(sweets));
        System.out.println("second remove: " + fruits.removeAll(sweets));
        System.out.println(fruits);
        for (String s : fruits) {
            System.out.println(s);
        }
    }
}
