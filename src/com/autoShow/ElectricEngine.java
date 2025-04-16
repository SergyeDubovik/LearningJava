package com.autoShow;

public class ElectricEngine extends Engine {
    private double batteryVolume;

    public ElectricEngine(int horsePower, double batteryVolume) {
        super(horsePower);
        this.batteryVolume = batteryVolume;
    }

    @Override
    public String toString() {
        return "ElectricEngine{" +
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
