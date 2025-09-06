package com.parking;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingImpl implements Parking {
    private final int size;
    private final boolean[] isFree;
    private final PricingCalculator calculator;
    private final Map<String, ParkingRecord> visitors = new HashMap<>();

    public ParkingImpl(int size, PricingCalculator calculator) {
        this.size = size;
        isFree = new boolean[size];
        Arrays.fill(isFree, true);
        this.calculator = calculator;
    }

    @Override
    public boolean enter(String carNumber) {
        for (int i = 0; i < isFree.length; i++) {
            if (isFree[i]) {
                isFree[i] = false;
                LocalDateTime enterCar = LocalDateTime.now().minusMinutes(110);
                ParkingRecord record = new ParkingRecord(i, enterCar);
                visitors.put(carNumber, record);
                try {
                    saveData(carNumber, enterCar, record.getSlot());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return true;
            }
        }
        return false;
    }

    private static void saveData(String carNumber, LocalDateTime enterTime, int slot) throws IOException {
        try
                (FileWriter fileWriter = new FileWriter("report_parking.csv", true)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            String formattedDate = enterTime.format(dateTimeFormatter);
            String line = "Enter car, " + carNumber + ", " + formattedDate + ", " + "slot - " + slot + "\n";
            fileWriter.write(line);
        }
    }


    @Override
    public BigDecimal exit(String carNumber) {
        if (!visitors.containsKey(carNumber)) {
            throw new RuntimeException("Car not found");
        }
        LocalDateTime now = LocalDateTime.now();
        ParkingRecord record = visitors.get(carNumber);
        LocalDateTime enterTime = record.getEnterTime();
        Duration duration = Duration.between(enterTime, now);
        isFree[record.getSlot()] = true;
        visitors.remove(carNumber);
        return calculator.calculate(duration);
    }
}

