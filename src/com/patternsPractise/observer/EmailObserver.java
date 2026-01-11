package com.patternsPractise.observer;

public class EmailObserver implements OrderObserver {
    @Override
    public void onOrderPlaced() {
        System.out.println("Email sent to customer");
    }
}
