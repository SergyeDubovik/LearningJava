package ganj;

import java.util.Scanner;

public class HumanRiddleMaker implements RiddleMaker {
    private final Scanner scanner;

    public HumanRiddleMaker(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void thinkOfNumberBetween(int from, int to) {
        System.out.println("Guess the number in the range from these bounds and press enter when you will ready");
        scanner.nextLine();
    }

    @Override
    public CompareResult check(int number) {
        System.out.println("Guess number " + number);
        System.out.println("If your secret number is greater than " + number + " please enter '>'\n" +
                "If your secret number is lower than " + number + " please enter '<'\n" +
                "If your secret number is equal to " + number + " please enter '='");
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case ">":
                    return CompareResult.GREATER;
                case "<":
                    return CompareResult.LOWER;
                case "=":
                    return CompareResult.EQUAL;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }
    }
}
