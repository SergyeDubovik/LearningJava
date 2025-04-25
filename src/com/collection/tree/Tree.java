package com.collection.tree;

public interface Tree<V> {
    V put(V value);
    V remove(V value);
    boolean contains(V value);
}
