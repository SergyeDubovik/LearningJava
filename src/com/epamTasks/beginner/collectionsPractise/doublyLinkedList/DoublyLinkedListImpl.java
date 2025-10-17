package com.epamTasks.beginner.collectionsPractise.doublyLinkedList;

import java.util.Optional;

public class DoublyLinkedListImpl implements DoublyLinkedList {
    private Node head;

    private Node tail;

    private static class Node {

        Object element;

        Node next;

        Node prev;

        Node(Object obj, Node prev, Node next) {
            this.element = obj;
            this.next = next;
            this.prev = prev;
        }

    }
    @Override
    public boolean addFirst(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
        Node node = new Node(element, null, head);
        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
        return true;
    }
    @Override
    public boolean addLast(Object element) {
        if (element == null) {
            return false;
        }
        Node node = new Node(element, tail, null);
        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        return true;
    }
    @Override
    public void delete(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode.prev == null) {
            head = currentNode.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (currentNode.next == null) {
            tail = currentNode.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }

    }
    @Override
    public Optional<Object> remove(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
        Node currentNode = head;
        while (currentNode != null) {
            if (element.equals(currentNode.element)) {
                if (currentNode.prev == null) {
                    head = currentNode.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (currentNode.next == null) {
                    tail = currentNode.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                return Optional.of(currentNode.element);
            }
            currentNode = currentNode.next;
        }
        return Optional.empty();
    }
    @Override
    public boolean set(int index, Object element) throws IndexOutOfBoundsException {
        if (element == null) {
            return false;
        }
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.element = element;
        return true;
    }

    @Override
    public int size() {
        int count = 0;
        Node currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node currentNode = head;
        for (int i = 0; i < array.length; i++) {
            array[i] = currentNode.element;
            currentNode = currentNode.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.element.toString());
            if (currentNode.next != null) {
                sb.append(" ");
            }
            currentNode = currentNode.next;
        }
        return sb.toString();
    }
}
