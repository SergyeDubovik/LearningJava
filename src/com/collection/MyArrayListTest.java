package com.collection;

public class MyArrayListTest {
    public static void main(String[] args) {
        testAdd(emptyList(), "apple");
        testAdd(of("door", "plate"), "glass");
        testAdd(of("pepsi", null, "coffee"), null);

        testRemove(of("cake", "mood"), 1);
        testRemove(of("cake", "mood", "cat", "dog"), 2);
        testRemove(of("cake", "mood", "cat", "dog"), 0);
        testRemove(of("cake"), 0);
        testRemoveNegative(of("soda", "sugar", "salt"), -1);
        testRemoveNegative(of("soda", "sugar", "salt"), 3);

        testContains(of("bat", "two", null, "three"), "bat");
        testContains(of("bat", "two", null, "three"), new String("two"));
        testContains(of("bat", "two", null, "three"), null);
        testContains(of("bat", "two", null, "three"), "three");
        testNotContains(of("bat", "two", "three"), "one");
        testNotContains(of("bat", "two", "three"), null);


    }

    private static void testAdd(MyArrayList list, String element) {
        int expectedSize = list.size() + 1;

        list.add(element);

        assertEquals(expectedSize, list.size());
        assertEquals(element, list.get(list.size() - 1));
    }

    private static void testRemove(MyArrayList list, int index) {
        int expectedSize = list.size() - 1;
        String expectedResult = list.get(index);

        String actualResult = list.remove(index);

        assertEquals(expectedSize, list.size());
        assertEquals(expectedResult, actualResult);
    }

    private static void testRemoveNegative(MyArrayList list, int index) {
        String expectedMessage = "Index mustn't be less than zero and more than the array's length";

        try {
            list.remove(index);
        } catch (IndexOutOfBoundsException e) {

            assertEquals(expectedMessage, e.getMessage());
        }
    }

    private static void testContains(MyArrayList list, String contains) {
        boolean result = list.contains(contains);

        assertTrue(result);
    }

    private static void testNotContains(MyArrayList list, String contains) {
        boolean result = list.contains(contains);

        assertFalse(result);
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
