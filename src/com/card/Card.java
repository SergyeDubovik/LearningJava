package com.card;


public class Card {
    private final Shape shape;
    private final String value;

    public Card(Shape shape, String value) {
        this.shape = shape;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + shape.getSymbol();
    }
}
