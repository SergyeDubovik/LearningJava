package com.autoShow;

public class PetrolEngine extends Engine {
    private double fuelVolume;

    public PetrolEngine(int horsePower, double fuelVolume) {
        super(horsePower);
        this.fuelVolume = fuelVolume;
    }

    @Override
    public String toString() {
        return "PetrolEngine{" + "fuelVolume=" + fuelVolume + '}';
    }
    public double getFuelVolume() {
        return fuelVolume;
    }
    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }
}
