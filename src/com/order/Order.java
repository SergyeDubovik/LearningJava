package com.order;

public class Order {
    private static int nextId = 1;
    private final int id;
    private String product;


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

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
