package com.autoShow;

import java.util.Objects;

public class Hatchback extends Car {
    public String color;

    public Hatchback(String brand, String model, Engine engine, String color) {
        super(brand, model, engine);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Hatchback{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hatchback hatchback = (Hatchback) o;
        return Objects.equals(color, hatchback.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
