package com.order;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static int nextId = 1;
    private final int id;
    private final Map<String, Integer> products;

    public Order() {
        id = nextId++;
        products = new HashMap<>();
    }

    public void addProducts(String item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be more than zero!");
        }
        products.put(item, products.getOrDefault(item, 0) + quantity);
    }

    public void removeProduct(String item) {
        products.remove(item);
    }

    public void removeProduct(String item, int quantity) {
        Integer value = products.get(item);
        if (value == null) {
            throw new IllegalArgumentException("there is no item found");
        }
        if (value - quantity < 0) {
            throw new IllegalArgumentException("quantity must be more than zero!");
        }
        if (value == quantity) {
            removeProduct(item);
            return;
        }
        products.put(item, value - quantity);
    }

    public void clearBasket() {
        products.clear();
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return "basket is empty";
        }
        StringBuilder sb = new StringBuilder("Order # ");
        sb.append(id);
        sb.append(", products - ");
        for (String s : products.keySet()) {
            sb.append("Name: ");
            sb.append(s);
            sb.append(", quantity: ");
            sb.append(products.get(s));
            sb.append("; ");
        }
        return sb.toString();
    }
}
