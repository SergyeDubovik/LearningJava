package ganj;

import java.util.Scanner;

import static ganj.CompareResult.GREATER;
import static ganj.CompareResult.LOWER;

public class HumanGuesser implements Guesser {
    private int from;
    private int to;
    private final Scanner scanner;

    public HumanGuesser(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public void initialize(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int makeGuess() {
        while (true) {
            System.out.print("Input your number: ");
            int guess = Integer.parseInt(scanner.nextLine());
            if (guess < from || guess > to) {
                System.out.println("You have to input a number in the range from " + from + " to " + to);
                continue;
            }
            return guess;
        }
    }

    @Override
    public void notifyResult(CompareResult cr) {
        if (cr.equals(GREATER)) {
            System.out.println("Guess number is greater");
        } else if (cr.equals(LOWER)) {
            System.out.println("Guess number is lower");
        } else {
            System.out.println("Congrats, You nailed it!");
        }
    }
}
