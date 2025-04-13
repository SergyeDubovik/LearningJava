package com.collection.stack;

import java.util.List;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> numbers = new MyStack<>();
        numbers.push(2);
        numbers.push(3);
        numbers.push(4);
        numbers.push(5);
        System.out.println(numbers.size());
    }
}
