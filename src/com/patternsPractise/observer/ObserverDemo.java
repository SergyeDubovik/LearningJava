package com.patternsPractise.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        service.addObserver(new EmailObserver());
        service.addObserver(new LogObserver());
        service.addObserver(new MetricsObserver());

        service.placeOrder();
    }
}
