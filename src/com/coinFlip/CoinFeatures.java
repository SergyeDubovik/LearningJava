package com.coinFlip;

import java.util.Random;

public class CoinFeatures {
    private int heads;
    private int tails;
    private int throwsCount;
    boolean sideCoin;
    private Random random;

    public CoinFeatures(int throwsCount) {
        this.heads = 0;
        this.tails = 0;
        this.random = new Random();
        this.throwsCount = throwsCount;
    }
    public void throwing() {
        for (int i = 1; i <= throwsCount; i++) {
            if (sideCoin) {
                heads++;
            } else {
                tails++;
            }
            if (i % 10 == 0) {
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

    public int getHeads() {
        return heads;
    }

    public int getTails() {
        return tails;
    }

    public boolean isSideCoin() {
        return sideCoin;
    }
}
