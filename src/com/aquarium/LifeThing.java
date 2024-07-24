package com.aquarium;

public class LifeThing {
    public String name;

    public LifeThing (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

