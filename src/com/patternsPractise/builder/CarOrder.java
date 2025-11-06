package com.patternsPractise.builder;

import java.time.Year;

public class CarOrder {
    private String brand;
    private String model;
    private String color;
    private double engineCapacity;
    private Year yearOfRelease;
    private int horsePower;

    private CarOrder(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.engineCapacity = builder.engineCapacity;
        this.yearOfRelease = builder.yearOfRelease;
        this.horsePower = builder.horsePower;
    }

    public static class Builder {
        private String brand;
        private String model;
        private String color;
        private double engineCapacity;
        private Year yearOfRelease;
        private int horsePower;

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder engineCapacity(double capacity) {
            this.engineCapacity = capacity;
            return this;
        }

        public Builder yearOfRelease(Year yearOfRelease) {
            this.yearOfRelease = yearOfRelease;
            return this;
        }

        public Builder horsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public CarOrder build() {
            return new CarOrder(this);
        }
    }

    @Override
    public String toString() {
        return "CarOrder{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", yearOfRelease=" + yearOfRelease +
                ", horsePower=" + horsePower +
                '}';
    }
}
