package com.parking;

import java.math.BigDecimal;
import java.util.Scanner;

public class ParkingCLI {
    public static void main(String[] args) {
        Parking someParking = new ParkingImpl(10, new SimplePricingCalculator());
        Scanner scanner = new Scanner(System.in);

        runMenu(someParking, scanner);

    }
    private static void runMenu(Parking parking, Scanner sc) {
        while (true) {
            displayMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    enterCar(parking, sc);
                    break;
                case "2":
                    exitCar(parking, sc);
                    break;
                case "0":
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Wrong input, try again");
            }
        }
    }

    private static void enterCar(Parking parking, Scanner scanner) {
        System.out.println("Waiting for input car number...");
        String carNumber = scanner.nextLine();
        boolean successInput = parking.enter(carNumber);
        if (successInput) {
            System.out.println("Car parked successfully");
        } else {
            System.out.println("Sorry, parking is already full");
        }
    }

    private static void exitCar(Parking parking, Scanner scanner) {
        System.out.println("Waiting for input car number...");
        String carNumberOnExit = scanner.nextLine();
        try {
            BigDecimal pay = parking.exit(carNumberOnExit);
            System.out.println("Was paid: " + pay + "$");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("Welcome to our car parking");
        System.out.println("1 - Enter");
        System.out.println("2 - Exit");
        System.out.println("0 - Close app");
    }
}
