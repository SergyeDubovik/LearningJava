package com.parking;

import java.io.*;
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
        if (visitors.containsKey(carNumber)) {
            throw new RuntimeException("Car " + carNumber + " is already parked");
        }
        for (int i = 0; i < isFree.length; i++) {
            if (isFree[i]) {
                isFree[i] = false;
                LocalDateTime enterCar = LocalDateTime.now();
                ParkingRecord record = new ParkingRecord(i, enterCar);
                visitors.put(carNumber, record);
                return true;
            }
        }
        System.out.println("Sorry, parking is already full");
        return false;
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

    @Override
    public void saveData() throws IOException {
        if (visitors.isEmpty()) {
            System.out.println("No cars to write");
            return;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("parking.csv", true))) {
            for (Map.Entry<String, ParkingRecord> entry : visitors.entrySet()) {
                ParkingRecord pr = entry.getValue();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedDate = pr.getEnterTime().format(dateTimeFormatter);
                String line = entry.getKey() + "," + formattedDate + "," + pr.getSlot() + "\n";
                bufferedWriter.write(line);
                System.out.println(line);
            }
        }
    }
}

