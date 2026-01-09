package com.patternsPractise.strategy;

public class DeliveryService {
    private DeliveryStrategy strategy;

    public DeliveryService(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double price) {
        return strategy.calculate(price);
    }
}
