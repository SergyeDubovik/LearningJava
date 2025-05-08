package com.collection.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class MyTreeSetTest {
    private final MyTreeSet<Integer> set = new MyTreeSet<>();
    @Test
    public void testAddWhenEmpty() {
        int expected = 5;

        int actual = set.put(expected);

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void testAdd() {
        populateSet();
        int expected = 8;
        int expectedSize = set.size() + 1;

        int actual = set.put(expected);
        int actualSize = set.size();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testContains() {
        populateSet();

        Assert.assertTrue(set.contains(7));
        Assert.assertTrue(set.contains(10));
        Assert.assertTrue(set.contains(2));
        Assert.assertTrue(set.contains(5));
    }

    @Test
    public void testNotContains() {
        populateSet();

        Assert.assertFalse(set.contains(1));
        Assert.assertFalse(set.contains(0));
        Assert.assertFalse(set.contains(22));
    }

    private void populateSet() {
        set.put(10);
        set.put(2);
        set.put(7);
        set.put(5);
    }
}
