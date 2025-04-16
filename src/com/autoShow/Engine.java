package com.autoShow;

public class Engine {
    private int horsePower;

    public Engine(int horsePower) {
        if (horsePower < 0) {
            throw new RuntimeException("Horse power can't be negative number");
        }
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
