package com.inputOutput;

import java.time.LocalDate;

public class Record {
    private final double temperature;
    private final LocalDate date;

    public Record(double temperature, LocalDate date) {
        this.temperature = temperature;
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return
                "temperature = " + temperature +
                ", date = " + date;
    }
}
