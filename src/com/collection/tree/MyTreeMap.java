package com.collection.tree;

import java.util.Set;
import java.util.TreeSet;

public class MyTreeMap<V extends Comparable<V>> implements Tree<V> {
    private final Set<V> values = new TreeSet<>();

    @Override
    public V put(V value) {
       values.add(value);
        return value;
    }

    @Override
    public V remove(V value) {
        if (values.remove(value)) {
            return value;
        }
        return null;
    }

    @Override
    public boolean contains(V value) {
        return values.contains(value);
    }

    @Override
    public String toString() {
        return "" + values;
    }
}
