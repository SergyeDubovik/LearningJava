package com.collection.arraylist;

import java.util.*;

public class MyArrayList implements List<String> {
    private String[] array;
    private int size;

    public MyArrayList() {
        array = new String[0];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(array, size);
    }

    @Override
    public boolean add(String string) {
//        проверяем, есть ли свободные места в массиве,
//        если нет, то создаем увеличенный массив, копируем элементы старого массива в новый
//        и добавляем элемент и сдвигаем указатель
//        если да - то добавляем элемент и сдвигаем указатель
        expandArray(1);
        array[size] = string;
        size += 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        if (c.isEmpty()) {
            return false;
        }
        String[] list = c.toArray(new String[0]);
        expandArray(c.size());
        System.arraycopy(list, 0, array, size, list.length);
        size += list.length;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (c.isEmpty()) {
            return false;
        }
        String[] list = c.toArray(new String[0]);
        expandArray(c.size());
        System.arraycopy(array, index, array, index + list.length, size - index);
        size += list.length;
        System.arraycopy(list, 0, array, index, list.length);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean change = false;
        for (int i = 0; i < size; i++) {
            if (c.contains(array[i])) {
                remove(array[i]);
                i--;
                change = true;
            }
        }
        return change;
    }

    /**
     * remove all elements that not contains in second list
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean change = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(array[i])) {
                remove(array[i]);
                i--;
                change = true;
            }
        }
        return change;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String get(int index) {
//        проверяем что индекс который у нас просят - доступен (имеется в списке)
//        возвращаем его если он есть и кидаем исключение если его нет
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public String set(int index, String element) {
        array[index] = element;
        return array[index];
    }

    @Override
    public void add(int index, String element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        expandArray(1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

//    public String remove(int index)
//        if (index < 0 || index >= this.index) {
//            throw new RuntimeException("Index mustn't be less than zero and more than the array's length");
//        }
//        String removed = array[index];
//        for (int i = index + 1; i < array.length; i++) {
//            array[i - 1] = array[i];
//        }
//        this.index--;
//        return removed;

//

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index mustn't be less than zero and more than the array's length");
        }
        String removed = array[index];
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
        return removed;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, array[i])) {
                return i;
            }
        }
        return -1;
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
        int subListSize = toIndex - fromIndex;
        String[] subList = new String[subListSize];
        System.arraycopy(array, fromIndex, subList, 0, subListSize);
        return Arrays.asList(subList);
    }

    private void expandArray(int count) {
        if (size + count > array.length) {
            String[] newArray = new String[(array.length + count) * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}
