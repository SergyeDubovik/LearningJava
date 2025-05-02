package com.collection.tree;

public class MyTreeSet<V extends Comparable<V>> implements Tree<V> {
    private Node<V> root;

    @Override
    public V put(V value) {
        if (root == null) {
            root = new Node<>(null, value);
        } else {
            root.put(value);
        }
        return value;
    }

    @Override
    public V remove(V value) {
        return null;
    }

    @Override
    public boolean contains(V value) {
        if (root == null) {
            return false;
        }
        return root.contains(value);
    }

    @Override
    public int size() {
        return root == null ? 0 : root.size();
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private static class Node<V extends Comparable<V>> {
        private Node<V> left;
        private Node<V> right;
        private Node<V> parent;
        private V value;

        public Node(Node<V> parent, V value) {
            this.parent = parent;
            this.value = value;
        }

        private void put(V value) {
            int compare = value.compareTo(this.value);
            if (compare > 0) {
                if (right == null) {
                    right = new Node<>(this, value);
                } else {
                    right.put(value);
                }
            }
            if (compare < 0) {
                if (left == null) {
                    left = new Node<>(this, value);
                } else {
                    left.put(value);
                }
            }
        }

        private boolean contains(V value) {
            int compare = value.compareTo(this.value);
            if (compare == 0) {
                return true;
            } else if (compare > 0) {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            } else {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            }
        }

        private int size() {
            int size = 1;
            if (left != null) {
                size += left.size();
            }
            if (right != null) {
                size += right.size();
            }
            return size;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (left != null) {
                sb.append(left).append(" ");
            }
            sb.append(value);
            if (right != null) {
                sb.append(" ").append(right);
            }
            return sb.toString();
        }
    }
}
