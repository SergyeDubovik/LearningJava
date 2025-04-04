package ganj;

import java.util.Random;
import java.util.Scanner;

public class GuessANumberJava {
    private static int origin;
    private static int bound;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean closeApp = false;
        while (!closeApp) {
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
                case "4":
                    System.out.println("Bye");
                    closeApp = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }

    }

    private static void mainMenu() {
        System.out.println("Welcome to Guess A Number game");
        System.out.println("Choose a game mode:");
        System.out.println("1 - AI v Player");
        System.out.println("2 - Player v AI");
        System.out.println("3 - How to play");
        System.out.println("4 - Close app");
    }

    private static void againstAI(Scanner scanner) {
        readRange(scanner);

        Random random = new Random();
        int secretNumber = random.nextInt(origin, bound + 1);
        int myNumber;
        int countOfGuesses = 1;
        while (true) {
            myNumber = readNumber(scanner);
            if (myNumber > bound || myNumber < origin) {
                System.out.println("You have to input number in the range from " + origin + " to " + bound);
                continue;
            }
            if (myNumber == secretNumber) {
                System.out.println("Congrats, You nailed it! It took you " + countOfGuesses + " attempts!\n");
                break;
            } else if (myNumber > secretNumber) {
                System.out.println("Hidden number is less than " + myNumber);
            } else {
                System.out.println("Hidden number is greater than " + myNumber);
            }
            countOfGuesses++;
        }
    }

    private static void readRange(Scanner scanner) {
        System.out.println("Enter the range of numbers you want the target number to be between.");
        while (true) {
            System.out.println("Origin:");
            origin = Integer.parseInt(scanner.nextLine());
            System.out.println("Bound:");
            bound = Integer.parseInt(scanner.nextLine());
            if (origin > bound) {
                System.out.println("Origin can't be greater than bound.");
            } else {
                break;
            }
        }
    }

    private static int readNumber(Scanner scanner) {
        while (true) {
            System.out.println("Please input your guess number:");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Specified input is not a number");
            }
        }
    }

    private static void help() {
        System.out.println("""
                Enter the range of numbers you want the target number to be between, and press New Target
                Enter your guess
                See if your guess is too high or too low
                Change your guess
                The app will tell you when you are right, and how many guesses you had
                 """);
    }
}
