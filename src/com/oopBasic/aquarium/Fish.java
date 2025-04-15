package com.oopBasic.aquarium;

public class Fish extends LifeThing {
    public String finColor;

    public Fish (String name, String color) {
        super(name);
        this.finColor = color;
    }
    @Override
    public String toString() {
        return super.toString() + " fin color is " + finColor;
    }
}
