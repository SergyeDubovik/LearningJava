package com.aquarium;

public class Shellfish extends LifeThing {
    public int limbCount;

    public Shellfish(String name, int limbCount) {
        super(name);
        this.limbCount = limbCount;
    }
    @Override
    public String toString() {
        return super.toString() + " limbs count - " + limbCount;
    }
}
