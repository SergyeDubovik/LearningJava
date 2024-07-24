package com.autoShow;

import java.util.Objects;

public class Sedan extends Car {
    public String color;
    public Sedan(String brand, String model, Engine engine, String color) {
        super(brand, model, engine);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sedan {" +
                "color = '" + color + '\'' +
                ", brand = '" + brand + '\'' +
                ", model = '" + model + '\'' +
                ", engine = '" + getEngine().toString() + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sedan sedan = (Sedan) o;
        return Objects.equals(color, sedan.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
