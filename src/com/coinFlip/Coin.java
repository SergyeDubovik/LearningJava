package com.coinFlip;

import java.util.Random;

public class Coin {
    public static void main(String[] args) {
        int heads = 0;
        int tails = 0;
        int throwCount = 10;
        Random random = new Random();
        for (int i = 1; i <= throwCount; i++) {
            boolean side = random.nextBoolean();
            if (side) {
                heads++;
            } else {
                tails++;
            }
        }
        double percentHeads = ((double) heads / throwCount) * 100;
        double percentTails = ((double) tails / throwCount) * 100;
        System.out.println(percentHeads);
        System.out.println(percentTails);

    }
}
