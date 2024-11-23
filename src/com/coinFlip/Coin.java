package com.coinFlip;

import java.util.Random;

public class Coin {
    private int heads;
    private int tails;
    private final int checkPeriod;
    private final int throwsCount;
    private final Random random;

    public Coin(int throwsCount, int checkPeriod) {
        this.heads = 0;
        this.tails = 0;
        this.checkPeriod = checkPeriod;
        this.random = new Random();
        this.throwsCount = throwsCount;
    }
    public void throwing() {
        for (int i = 1; i <= throwsCount; i++) {
            if (random.nextBoolean()) {
                heads++;
            } else {
                tails++;
            }
            if (i % checkPeriod == 0) {
                System.out.print("iteration " + i + " - ");
                System.out.print("heads: " + heads + ", tails: " + tails);
                System.out.println();
            }

        }
        outcome();
    }
    public void outcome () {
        double percentHeads = ((double) heads / throwsCount) * 100;
        double percentTails = ((double) tails / throwsCount) * 100;
        System.out.println("Heads: " + percentHeads + "%");
        System.out.println("Tails: " + percentTails + "%");
    }

}
