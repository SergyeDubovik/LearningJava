package ganj;

import java.util.Random;
import java.util.Scanner;

public class GuessANumberJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainMenu();
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                againstAI(scanner);
                break;
            case "2":
                System.out.println("Soon...");
                break;
            case "3":
                help();
                break;
            default:
                System.out.println("Wrong input");
                break;
        }


    }

    private static void mainMenu() {
        System.out.println("Welcome to Guess A Number game");
        System.out.println("Choose o game mode:");
        System.out.println("1 - AI v Player");
        System.out.println("2 - Player v AI");
        System.out.println("3 - How to play");
        System.out.println("4 - Close app");
    }

    private static void againstAI(Scanner scanner) {
        Random random = new Random();
        System.out.println("Enter the range of numbers you want the target number to be between:");
        int bound = scanner.nextInt();
        int secretNumber = random.nextInt(bound) + 1;
        int myNumber;
        while (true) {
            System.out.println("Please input your guess number:");
            myNumber = scanner.nextInt();
            if (myNumber == secretNumber) {
                System.out.println("Congrats, U nailed it!");
                break;
            } else if (myNumber > secretNumber) {
                System.out.println("Your number must be less than hidden number");
            } else {
                System.out.println("Your number must be greater than hidden number");
            }
        }
    }

    private static void help() {
        System.out.println("""
                Enter the range of numbers you want the target number to be between, and press New Target
                Enter your guess
                See if your guess is too high or too low
                Change your guess
                The app will tell you when you are right, and how many guesses you had""");
    }
}
