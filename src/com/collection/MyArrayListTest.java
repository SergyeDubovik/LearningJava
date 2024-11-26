package com.collection;

import java.util.List;

public class MyArrayListTest {
    public static void main(String[] args) {
        testAdd(emptyList(), "apple");
        testAdd(of("door", "plate"), "glass");
        testAdd(of("pepsi", null, "coffee" ), null);


    }
    private static void testAdd(MyArrayList list, String element) {
        int expectedSize = list.size() + 1;

        list.add(element);

        assertEquals(expectedSize, list.size());
        assertEquals(element, list.get(list.size() - 1));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("Actual number isn't equal to expected number!");
        }
    }

    private static void assertEquals(String expected, String actual) {
        if ((expected != null || actual != null) && (expected == null || !expected.equals(actual))) {
            throw new RuntimeException("Actual string isn't equal to expected string!");
        }
    }

    private static MyArrayList emptyList() {
        return new MyArrayList();
    }

    private static MyArrayList of(String... strings) {
        MyArrayList list = new MyArrayList();
        for (String string : strings) {
            list.add(string);
        }
        return list;
    }
}
