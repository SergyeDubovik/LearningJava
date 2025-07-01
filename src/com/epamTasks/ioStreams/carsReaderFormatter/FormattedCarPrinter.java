package com.epamTasks.ioStreams.carsReaderFormatter;

import java.util.List;
import java.util.Locale;

public class FormattedCarPrinter {
    public void print(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf(Locale.US,"%10s %10s %5d ccm %3d kw %5.2f sec%n", car.getBrand(),
                    car.getModel(), car.getCylinderCapacityCcm(), car.getPerformanceKwh(), car.getAccelerationSec());
        }
    }
}
