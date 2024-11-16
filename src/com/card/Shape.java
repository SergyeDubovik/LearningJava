package com.card;

public enum Shape {
    SPADES("♠"),
    CLUBS("♣"),
    DIAMONDS("♦"),
    HEARTS("♥");
    final String symbol;

    Shape(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
