package com.oopBasic.toys;

public class Car extends Toy {
    private String type;

    public Car(String name, String type) {
        super(name);
        this.type = type;

    }

    @Override
    public String toString() {
        return "Car {" +
                "type = '" + type + '\'' +
                ", name = '" + getName() + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
