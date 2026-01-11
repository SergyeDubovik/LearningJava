package com.patternsPractise.observer;

public class LogObserver implements OrderObserver {
    @Override
    public void onOrderPlaced() {
        System.out.println("order logged");
    }
}
