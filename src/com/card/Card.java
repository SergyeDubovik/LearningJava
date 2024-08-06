package com.card;

public class Card {
    private Shape shape;
    private int value;

    public Card(Shape shape, int value) {
        this.shape = shape;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "shape=" + shape +
                ", value=" + value +
                '}';
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
