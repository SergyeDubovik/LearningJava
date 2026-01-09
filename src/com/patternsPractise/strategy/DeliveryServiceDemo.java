package com.patternsPractise.strategy;

public class DeliveryServiceDemo {
    public static void main(String[] args) {
        DeliveryStrategy strategy = new CarDeliveryStrategy();
        DeliveryService service = new DeliveryService(strategy);
        System.out.println(service.calculate(100));
    }
}
