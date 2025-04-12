package ganj;

import java.util.Random;
import java.util.Scanner;

import static ganj.CompareResult.GREATER;
import static ganj.CompareResult.LOWER;

public class AIGuesser implements Guesser {
    private int from;
    private int to;
    private int guessByAI;

    @Override
    public void initialize(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int makeGuess() {
        return guessByAI = (from + to) / 2;
    }

    @Override
    public void notifyResult(CompareResult compareResult) {
        if (compareResult == CompareResult.GREATER) {
            System.out.println("Guess number is greater");
            from = guessByAI + 1;
        } else if (compareResult == CompareResult.LOWER) {
            System.out.println("Guess number is lower");
            to = guessByAI - 1;
        } else {
            System.out.println("Congrats, You nailed it!");
        }
    }
}
