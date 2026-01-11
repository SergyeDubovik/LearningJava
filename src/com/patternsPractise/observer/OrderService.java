package com.patternsPractise.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<OrderObserver> observerList = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observerList.remove(observer);
    }

    public void placeOrder() {
        System.out.println("order placed");
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderObserver observer : observerList) {
            observer.onOrderPlaced();
        }
    }
}
