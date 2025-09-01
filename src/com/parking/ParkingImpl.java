package com.parking;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingImpl implements Parking {
    private int size;
    private boolean[] isFree;
    private PricingCalculator calculator;
    private Map<String, ParkingRecord> visitors = new HashMap<>();

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
                LocalDateTime enterCar = LocalDateTime.now().minusMinutes(90);
                ParkingRecord record = new ParkingRecord(i, enterCar);
                visitors.put(carNumber, record);
                return true;
            }
        }
        return false;
    }

    @Override
    public BigDecimal exit(String carNumber) {
        if (!visitors.containsKey(carNumber)) {
            throw new RuntimeException();
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

