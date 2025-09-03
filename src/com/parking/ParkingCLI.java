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
            menuDisplay();
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Waiting for input car number...");
                    String carNumber = sc.nextLine();
                    boolean successInput = parking.enter(carNumber);
                    if (successInput) {
                        System.out.println("Car may parking");
                    } else {
                        System.out.println("Sorry, parking already full");
                    }
                    break;
                case "2":
                    System.out.println("Waiting for input car number...");
                    String carNumberOnExit = sc.nextLine();
                    BigDecimal pay = parking.exit(carNumberOnExit);
                    System.out.println("Was paid: " + pay);
                    break;
                case "0":
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Wrong input, try again");
            }
        }
    }
    private static void menuDisplay() {
        System.out.println("Welcome to our car parking");
        System.out.println("1 - Enter");
        System.out.println("2 - Exit");
        System.out.println("0 - Close app");
    }
}
