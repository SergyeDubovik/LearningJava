package com.coinFlip;

import java.util.Random;

public class Coin {
    public static void main(String[] args) {
        int heads = 0;
        int tails = 0;
        int throwsCount = 100;
        Random random = new Random();
        for (int i = 1; i <= throwsCount; i++) {
            boolean side = random.nextBoolean();
            if (side) {
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
        System.out.println();
        double percentHeads = ((double) heads / throwsCount) * 100;
        double percentTails = ((double) tails / throwsCount) * 100;
        System.out.println("Heads: " + percentHeads + "%");
        System.out.println("Tails: " + percentTails + "%");

    }
}
