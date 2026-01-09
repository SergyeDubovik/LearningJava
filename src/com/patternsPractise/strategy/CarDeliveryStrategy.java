package com.patternsPractise.strategy;

public class CarDeliveryStrategy implements DeliveryStrategy {
    @Override
    public double calculate(double price) {
        return price * 1.3;
    }
}
