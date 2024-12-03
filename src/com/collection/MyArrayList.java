package com.collection;

import java.util.*;

public class MyArrayList implements List<String> {
    private String[] array;
    private int index;

    public MyArrayList() {
        array = new String[0];
        index = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < index; i++) {
            sb.append(array[i]);
            if (i != index - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < array.length; i++) {
            if (array[i] == (o)) {
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String string) {
//        проверяем, есть ли свободные места в массиве,
//        если нет, то создаем увеличенный массив, копируем элементы старого массива в новый
//        и добавляем элемент и сдвигаем указатель
//        если да - то добавляем элемент и сдвигаем указатель
        if (index == array.length) {
            String[] newArray = new String[(array.length + 1) * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[index] = string;
        index += 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
//        проверяем что индекс который у нас просят - доступен (имеется в списке)
//        возвращаем его если он есть и кидаем исключение если его нет
        if (index > this.index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
//    public String remove(int index) {
//        if (index < 0 || index >= this.index) {
//            throw new RuntimeException("Index mustn't be less than zero and more than the array's length");
//        }
//        String removed = array[index];
//        for (int i = index + 1; i < array.length; i++) {
//            array[i - 1] = array[i];
//        }
//        this.index--;
//        return removed;

//    }

    public String remove(int index) {
        String removed = array[index];
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        this.index--;
        return removed;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
