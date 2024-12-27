package com.collection;

import java.util.List;

public class MyArrayListTest {
    public static void main(String[] args) {
        testAdd(emptyList(), "apple");
        testAdd(of("door", "plate"), "glass");
        testAdd(of("pepsi", null, "coffee"), null);

        testAddIndex(of("coin", "rocket"), 1, "shit");
        testAddIndex(of("coin", "rocket"), 0, "circle");
        testAddIndex(of("coin", "rocket"), 2, "circle");
        testAddIndex(of("coin", "rocket"), 2, null);

        testRemove(of("cake", "mood"), 1);
        testRemove(of("cake", "mood", "cat", "dog"), 2);
        testRemove(of("cake", "mood", "cat", "dog"), 0);
        testRemove(of("cake"), 0);
        testRemoveNegative(of("soda", "sugar", "salt"), -1);
        testRemoveNegative(of("soda", "sugar", "salt"), 3);


        testContains(of("bat", "two", null, "three"), "bat");
        testContains(of("bat", "two", null, "three"), "two");
        testContains(of("bat", "two", null, "three"), null);
        testContains(of("bat", "two", null, "three"), "three");
        testNotContains(of("bat", "two", "three"), "one");
        testNotContains(of("bat", "two", "three"), null);

        testListIsEmptyAfterClear();

        testRemove(of("bat", "two", "three"), "two");
        testRemoveNegative(of("bat", "two", "three"), "cat");

        testSet(of("cat", "dog", "bull"), 1, "ape");
        testSet(of("cat", "dog", "bull"), 2, "donkey");

        testContainsAll(of("red", "white"), of("red"));
        testContainsAll(of("red", "white"), of("white", "red"));
        testContainsAll(of("red", "white"), new MyArrayList());

        testContainsAllNegative(of("red", "white"), of("black"));
        testContainsAllNegative(of("red", "white"), of("black", "red", "white"));
        testContainsAllNegative(new MyArrayList(), of("black", "red", "white"));

        testRemoveAll(of("one", "two", "three"), of("two"));
        testRemoveAll(of("one", "two", "three"), of("two", "one"));
        testRemoveAll(of("one", "two", "three"), of("two", "one", "four"));

        testRemoveAllNegative(of("one", "two", "three"), of("four", "five"));
        testRemoveAllNegative(new MyArrayList(), of("four", "five"));

        testRetainAll(of("one", "two"), of("one"));
        testRetainAll(of("one", "two"), of("one", "six", "seven"));

        testRetainAllNegative(of("one", "two"), of("one", "two"));
        testRetainAllNegative(new MyArrayList(), of("one", "two"));

        testSubList(of("one", "two", "three"), 0, 2);
        testSubList(of("one", "two", "three"), 1, 3);
        testSubList(of("one", "two", "three"), 0, 3);

    }

    private static void testAdd(MyArrayList list, String element) {
        int expectedSize = list.size() + 1;

        list.add(element);

        assertEquals(expectedSize, list.size());
        assertEquals(element, list.get(list.size() - 1));
    }

    private static void testAddIndex(MyArrayList list, int index, String element) {
        int expectedSize = list.size() + 1;

        list.add(index, element);

        assertEquals(expectedSize, list.size());
        assertEquals(element, list.get(index));
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

    private static void testRemove(MyArrayList list, Object o) {
        int expectedSize = list.size() - 1;

        boolean result = list.remove(o);

        assertEquals(expectedSize, list.size());
        assertTrue(result);
        assertFalse(list.contains(o));
    }

    private static void testRemoveNegative(MyArrayList list, Object o) {
        int expectedSize = list.size();

        boolean result = list.remove(o);

        assertEquals(expectedSize, list.size());
        assertFalse(result);
        assertFalse(list.contains(o));
    }

    private static void testContains(MyArrayList list, String contains) {
        boolean result = list.contains(contains);

        assertTrue(result);
    }

    private static void testNotContains(MyArrayList list, String contains) {
        boolean result = list.contains(contains);

        assertFalse(result);
    }

    private static void testListIsEmptyAfterClear() {
        MyArrayList list = new MyArrayList();

        assertTrue(list.isEmpty());

        list.add("zombie");

        assertFalse(list.isEmpty());

        list.clear();

        assertTrue(list.isEmpty());
    }

    private static void testSet(MyArrayList list, int index, String element) {

        int expectedSize = list.size();

        list.set(index, element);

        String expectedResult = list.get(index);

        assertEquals(expectedSize, list.size());
        assertEquals(expectedResult, element);

    }

    private static void testContainsAll(MyArrayList list, MyArrayList list2) {

        boolean compare = list.containsAll(list2);

        assertTrue(compare);

    }

    private static void testContainsAllNegative(MyArrayList list, MyArrayList list2) {

        boolean compare = list.containsAll(list2);

        assertFalse(compare);

    }

    private static void testRemoveAll(MyArrayList list, MyArrayList list2) {

        int sizeBefore = list.size();

        boolean result = list.removeAll(list2);

        for (String s : list2) {
            assertFalse(list.contains(s));
        }

        int sizeAfter = list.size();

        assertFalse(sizeBefore == sizeAfter);

        assertTrue(result);
    }

    private static void testRemoveAllNegative(MyArrayList list, MyArrayList list2) {

        int sizeBefore = list.size();

        boolean result = list.removeAll(list2);

        assertFalse(result);

        int sizeAfter = list.size();

        assertTrue(sizeBefore == sizeAfter);


    }

    private static void testRetainAll(MyArrayList list, MyArrayList list2) {

        boolean result = list.retainAll(list2);

        assertTrue(result);
    }

    private static void testRetainAllNegative(MyArrayList list, MyArrayList list2) {

        int sizeBefore = list.size();

        boolean result = list.retainAll(list2);

        assertFalse(result);

        int sizeAfter = list.size();

        assertTrue(sizeBefore == sizeAfter);
    }

    private static void testSubList(MyArrayList list, int fromIndex, int toIndex) {

        int expectedSize = toIndex - fromIndex;

        List<String> subList = list.subList(fromIndex, toIndex);

        assertEquals(expectedSize, subList.size());
        assertTrue(list.containsAll(subList));
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
