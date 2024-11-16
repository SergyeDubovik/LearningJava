package com.card;

import static javax.swing.text.html.HTML.Tag.U;

public class Card {
    private Shape shape;
    private String value;

    public Card(Shape shape, String value) {
        this.shape = shape;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + shape.getSymbol();
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
