package com.order;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static int nextId = 1;
    private final int id;
    private final Map<String, Integer> product;


    public Order() {
        id = nextId++;
        product = new HashMap<>();
    }

    public void addProducts(String item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be more than zero!");
        }
        product.put(item, product.getOrDefault(item, 0) + 1);
    }

    public void clearBasket() {
        product.clear();
    }

    @Override
    public String toString() {
        if (product.isEmpty()) {
            return "basket is empty";
        }
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}
