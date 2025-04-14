package ganj;

import java.util.Scanner;

public class GuessANumberJava {
    private static boolean closeApp = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Guess A Number game");
        while (!closeApp) {
            mainMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    playHumanGuesser(scanner);
                    break;
                case "2":
                    playAIGuesser(scanner);
                    break;
                case "3":
                    humanVHuman(scanner);
                    break;
                case "4":
                    AIAgainstAI(scanner);
                    break;
                case "5":
                    helpMessage();
                    break;
                case "6":
                    closeApp(scanner);
                    break;
                default:
                    System.out.println("Invalid input. Try to input a number from the main menu points");
                    break;
            }
        }

    }

    private static void mainMenu() {
        System.out.println("Choose a game mode:");
        System.out.println("1 - AI v Player");
        System.out.println("2 - Player v AI");
        System.out.println("3 - Player v Player");
        System.out.println("4 - AI v AI");
        System.out.println("5 - How to play");
        System.out.println("6 - Close app");
    }

    private static void playHumanGuesser(Scanner scanner) {
        GameRound gameRound = new GameRound(new AIRiddleMaker(), new HumanGuesser(scanner), scanner);
        gameRound.process();
    }

    private static void playAIGuesser(Scanner scanner){
        GameRound gameRound = new GameRound(new HumanRiddleMaker(scanner), new AIGuesser(), scanner);
        gameRound.process();
    }

    private static void humanVHuman(Scanner scanner) {
        GameRound gameRound = new GameRound(new HumanRiddleMaker(scanner), new HumanGuesser(scanner), scanner);
        gameRound.process();
    }

    private static void AIAgainstAI(Scanner scanner) {
        GameRound gameRound = new GameRound(new AIRiddleMaker(), new AIGuesser(), scanner);
        gameRound.process();
    }

    private static void helpMessage() {
        System.out.println("""
                Enter the range of numbers you want the target number to be between, and press Enter
                Enter your guess
                See if your guess is too high or too low
                Change your guess
                The app will tell you when you are right, and how many guesses you had
                 """);
    }

    private static void closeApp(Scanner scanner) {
        System.out.println("Are you sure? Enter 'Y' to close the app or 'N' to return to the menu");
        while (true) {
            String confirm = scanner.nextLine().trim().toUpperCase();
            if (confirm.equals("Y")) {
                System.out.println("Bye");
                closeApp = true;
                break;
            } else if (confirm.equals("N")) {
                System.out.println("Return to menu");
                break;
            } else {
                System.out.println("Invalid input, try again!");
            }
        }
    }
}
