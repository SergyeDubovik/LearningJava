package com.oopBasic.aquarium;

public class GoldFish extends Fish {
    public String scalesColor;

    public GoldFish(String name, String finColor, String scalesColor) {
        super(name, finColor);
        this.scalesColor = scalesColor;
    }
    @Override
    public String toString() {
        return super.toString() + " scales color is " + scalesColor;
    }
}
