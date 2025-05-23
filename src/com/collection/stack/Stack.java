package com.collection.stack;

public interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    int size();
}
