package com.order;

import java.util.Map;

public class OrderTest {
    public static void main(String[] args) {


    }

    private static void testAddProduct(Map<String, Integer> list, String expected, String actual) {
        assertTrue(list.containsKey(expected));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("Actual number isn't equal to expected number!");
        }
    }

    private static void assertTrue(boolean actual) {
        if (!actual) {
            throw new RuntimeException("Actual result is false");
        }
    }

    private static void assertFalse(boolean actual) {
        if (actual) {
            throw new RuntimeException("Actual result is true");
        }
    }
}
