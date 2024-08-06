package com.card;

public class Demo {
    public static void main(String[] args) {
        Card[] cards = new Card[] {
                new Card(Shape.HEARTS, 7),
                new Card(Shape.DIAMONDS, 9),
                new Card(Shape.CLUBS, 10)
        };
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
    }
}
