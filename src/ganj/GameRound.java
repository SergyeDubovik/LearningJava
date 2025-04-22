package ganj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameRound {
    private final RiddleMaker riddleMaker;
    private final Guesser guesser;
    private final Scanner scanner;
    private int attempts;
    private int origin;
    private int bound;

    public GameRound(RiddleMaker riddleMaker, Guesser guesser, Scanner scanner) {
        this.riddleMaker = riddleMaker;
        this.guesser = guesser;
        this.scanner = scanner;
    }

    public void process() {
        readRange(scanner);
        riddleMaker.thinkOfNumberBetween(origin, bound);
        guesser.initialize(origin, bound);
        Map<Integer, CompareResult> history = new HashMap<>();
        while (true) {
            int guessNumber = guesser.makeGuess();
            CompareResult result = riddleMaker.check(guessNumber);
            if (history.containsKey(guessNumber)) {
                if (result != history.get(guessNumber)) {
                    throw new IllegalStateException("You cheater");
                }
            } else {
                history.put(guessNumber, result);
            }
            guesser.notifyResult(result);
            attempts++;
            if (result == CompareResult.EQUAL) {
                System.out.println("It took you " + attempts + " attempts!\n");
                break;
            }
        }

    }
    private void readRange(Scanner scanner) {
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
}
