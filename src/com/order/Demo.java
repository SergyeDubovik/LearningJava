package com.order;

public class Demo {
    public static void main(String[] args) {
        Order order = new Order();
        order.addProducts("laptop", 2);
        order.addProducts("headphones", 1);
        System.out.println(order);
        Order order2 = new Order();
        order2.addProducts("lamp", 3);
        order2.addProducts("battery", 4);
        order2.addProducts("power bank", 1);
        System.out.println(order2);
        order.clearBasket();
        System.out.println(order);
        order2.removeProduct("lamp", 1);
        System.out.println(order2);

    }
}
