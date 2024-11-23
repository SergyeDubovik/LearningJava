package com.coinFlip;

public class CoinDemo {
    public static void main(String[] args) {
        Coin coin = new Coin(100, 10);
        coin.throwing();
        Coin anotherOne = new Coin(1000, 100);
        anotherOne.throwing();
    }
}
