package com.epamTasks.beginner.collectionsPractise.simpleArrayList;

import java.util.Optional;

public class SimpleArrayListImpl implements SimpleArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int FACTOR_MULTIPLIER = 2;
    private static final double INCREASE_LOAD_FACTOR = 0.75;
    private static final double DECREASE_LOAD_FACTOR = 0.4;

    private Object[] elements;
    private int size;

    /**
     * Creates a list with the default capacity = 10.
     */
    public SimpleArrayListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if ((size + 1) > elements.length * INCREASE_LOAD_FACTOR) {
            int newCapacity = (int) (elements.length * FACTOR_MULTIPLIER * INCREASE_LOAD_FACTOR);
            resize(newCapacity);
        }
        elements[size] = element;
        size += 1;
        return true;
    }

    private void resize(int expandCapacity) {
        Object[] newArray = new Object[expandCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public boolean decreaseCapacity() {
        if (size <= elements.length * DECREASE_LOAD_FACTOR) {
            int newCapacity = size * FACTOR_MULTIPLIER;
            if (newCapacity == DEFAULT_CAPACITY) {
                newCapacity = DEFAULT_CAPACITY;
            }
            resize(newCapacity);
            return true;
        }
        return false;
    }


    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Optional<Object> remove(Object el) {
        if (el == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(el)) {
                Object removed = elements[i];
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[size - 1] = null;
                size -= 1;
                return Optional.of(removed);
            }
        }
        return Optional.empty();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if ((size == 0)) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
