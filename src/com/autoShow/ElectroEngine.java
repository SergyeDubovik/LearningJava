package com.autoShow;

public class ElectroEngine extends Engine {
    private double batteryVolume;

    public ElectroEngine(int horsePower, double batteryVolume) {
        super(horsePower);
        this.batteryVolume = batteryVolume;
    }

    @Override
    public String toString() {
        return "ElectroEngine{" +
                "batteryVolume=" + batteryVolume +
                '}';
    }

    public double getBatteryVolume() {
        return batteryVolume;
    }

    public void setBatteryVolume(double batteryVolume) {
        this.batteryVolume = batteryVolume;
    }
}
