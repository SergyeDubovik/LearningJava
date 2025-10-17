package com.epamTasks.beginner.ioStreams.carsReaderFormatter;

import java.io.File;
import java.util.List;

public class CarsDemo {
    private static final CarCsvReader fileScanner = new CarCsvReader();
    private static final FormattedCarPrinter formattedCarPrinter = new FormattedCarPrinter();

    public static void main(String[] args) {
        String basePath = "C:/Users/Сергей/IdeaProjects/Audi/src/com/epamTasks/ioStreams/carsReaderFormatter/";
        File inputFile = new File(basePath +"data/cars.csv");
        List<Car> cars = fileScanner.readCars(inputFile);
        formattedCarPrinter.print(cars);
    }

}
