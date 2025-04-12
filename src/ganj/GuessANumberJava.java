package ganj;

import java.util.Scanner;

public class GuessANumberJava {
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
                    againstHuman(scanner);
                    break;
                case "3":
                    helpMessage();
                    break;
                case "4":
                    System.out.println("Bye");
                    closeApp = true;
                    break;
                default:
                    System.out.println("Invalid input. Try to input a number from the main menu points");
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
        GameRound gameRound = new GameRound(new AIRiddleMaker(), new HumanGuesser(scanner), scanner);
        gameRound.process();
    }

    private static void againstHuman(Scanner scanner){
        GameRound gameRound = new GameRound(new HumanRiddleMaker(), new AIGuesser(), scanner);
        gameRound.process();
    }

    private static void helpMessage() {
        System.out.println("""
                Enter the range of numbers you want the target number to be between, and press New Target
                Enter your guess
                See if your guess is too high or too low
                Change your guess
                The app will tell you when you are right, and how many guesses you had
                 """);
    }
}
