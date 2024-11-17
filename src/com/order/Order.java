package com.order;

public class Order {
    private static int nextId = 1;
    private final int id;
    private final String product;


    public Order(String product) {
        id = nextId++;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                '}';
    }
}
