package ganj;

import java.util.Random;
import java.util.Scanner;

import static ganj.CompareResult.GREATER;
import static ganj.CompareResult.LOWER;

public class AIGuesser implements Guesser {
    private int from;
    private int to;
    private final Scanner scanner;

    public AIGuesser(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public void initialize(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int makeGuess() {
        Random random = new Random();
        return random.nextInt(from, to + 1);
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
