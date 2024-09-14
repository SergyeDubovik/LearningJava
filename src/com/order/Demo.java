package com.order;

public class Demo {
    public static void main(String[] args) {
        Order order = new Order("watch");
        Order order2 = new Order("shirt");
        Order order3 = new Order("shirt");
        Order order4 = new Order("trousers");
        System.out.println(order);
        System.out.println(order2);
        System.out.println(order4);

    }
}
