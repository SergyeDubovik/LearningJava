package com.patternsPractise.builder;

import java.time.Year;

public class CarOrderDemo {
    public static void main(String[] args) {
        CarOrder order = new CarOrder.Builder()
                .brand("Audi")
                .model("Q7")
                .color("black")
                .engineCapacity(4.5)
                .yearOfRelease(Year.of(2024))
                .horsePower(400)
                .build();
        System.out.println(order);
    }
}
