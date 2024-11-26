package com.collection;

import java.util.ArrayList;
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
        System.out.println(fruits.get(3));
        System.out.println(fruits.size());
        System.out.println(fruits.isEmpty());

    }
}
