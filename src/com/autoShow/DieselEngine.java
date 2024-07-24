package com.autoShow;

public class DieselEngine extends Engine {
    private double fuelVolume;

    public DieselEngine(int horsePower, double fuelVolume) {
        super(horsePower);
        this.fuelVolume = fuelVolume;
    }

    @Override
    public String toString() {
        return "DieselEngine{" +
                "fuelVolume = " + fuelVolume +
                ", horsePowers = " + getHorsePower() +
                '}';
    }
}
