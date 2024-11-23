package com.coinFlip;

import java.util.Random;

public class Coin {
    private int heads;
    private int tails;
    private final int throwsCount;
    private final Random random;

    public Coin(int throwsCount) {
        this.heads = 0;
        this.tails = 0;
        this.random = new Random();
        this.throwsCount = throwsCount;
    }

    public void throwCoin() {
        int step = 10;
        for (int i = 1; i <= throwsCount; i++) {
            if (random.nextBoolean()) {
                heads++;
            } else {
                tails++;
            }
            if (i == step) {
                double headsPercent = ((double) heads / i) * 100;
                double tailsPercent = ((double) tails / i) * 100;
                step *= 10;
                System.out.print("iteration " + i + " - ");
                System.out.print("heads: " + heads + ", tails: " + tails +
                        ",  percent: Heads - " + headsPercent + " Tails -  " + tailsPercent);
                System.out.println();
            }
        }
        outcome();
    }

    private void outcome() {
        double percentHeads = ((double) heads / throwsCount) * 100;
        double percentTails = ((double) tails / throwsCount) * 100;
        System.out.println("Heads: " + percentHeads + "%");
        System.out.println("Tails: " + percentTails + "%");
    }

}
