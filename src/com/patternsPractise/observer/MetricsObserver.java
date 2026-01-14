package com.patternsPractise.observer;

public class MetricsObserver implements OrderObserver {
    @Override
    public void onOrderPlaced() {
        System.out.println("metrics updated");
    }
}
