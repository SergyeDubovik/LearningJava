package com.epamTasks.ioStreams.carsReaderFormatter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarCsvReader {
    public List<Car> readCars(File file) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(",");
                String brand = scanner.next();
                String model = scanner.next();
                int cylinderCapacityCcm = Integer.parseInt(scanner.next());
                int performanceKwh = Integer.parseInt(scanner.next());
                double accelerationSec = Double.parseDouble(scanner.next());
                Car car = new Car(brand, model, cylinderCapacityCcm, performanceKwh, accelerationSec);
                cars.add(car);
                scanner.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
