package com.collection.tree;

public class MyTreeMapDemo {
    public static void main(String[] args) {
        Tree<Integer> tree = new MyTreeMap<>();
        tree.put(5);
        tree.put(6);
        tree.put(45);
        tree.put(7);
        tree.put(2);
        System.out.println(tree);
        System.out.println(tree.contains(7));
    }
}
