package com.collection.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> implements Stack<T> {
    private final List<T> list = new ArrayList<>();

    @Override
    public void push(T element) {
        list.add(element);
    }

    @Override
    public T pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
