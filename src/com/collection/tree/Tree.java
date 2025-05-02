package com.collection.tree;

public interface Tree<V extends Comparable<V>> {
    V put(V value);
    V remove(V value);
    boolean contains(V value);
    int size();
}
