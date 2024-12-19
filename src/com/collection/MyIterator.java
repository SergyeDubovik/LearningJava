package com.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator implements Iterator<String> {
    private MyArrayList list;
    private int index;

    public MyIterator(MyArrayList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public String next() {
        if (index < list.size()) {
            index++;
            return list.get(index - 1);
        }
        throw new NoSuchElementException();
    }
}
