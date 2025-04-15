package com.oopBasic.toys;

public class ConstructionCar extends Car {
    private String color;
    private int price;
    public ConstructionCar(String name, String type, String color, int price) {
        super(name, type);
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ConstructionCar {" +
                "color = '" + color + '\'' +
                ", price = " + price +
                ", type = '" + getType() + '\'' +
                ", name = '" + getName() + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }
}
