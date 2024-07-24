package com.autoShow;

public class Truck extends Car {
    public int wheelsCount;
    public Truck(String brand, String model, Engine engine, int wheelsCount) {
        super(brand, model,engine);
        this.wheelsCount = wheelsCount;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "wheelsCount=" + wheelsCount +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
