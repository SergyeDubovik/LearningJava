package com.card;

import java.util.Random;

import static testArrays.Temp.printObjectArray;

public class Demo {
    public static void main(String[] args) {
        Card[] cards = new Card[] {
                new Card(Shape.HEARTS, "6"),
                new Card(Shape.HEARTS, "7"),
                new Card(Shape.HEARTS, "8"),
                new Card(Shape.HEARTS, "9"),
                new Card(Shape.HEARTS, "10"),
                new Card(Shape.HEARTS, "J"),
                new Card(Shape.HEARTS, "Q"),
                new Card(Shape.HEARTS, "K"),
                new Card(Shape.HEARTS, "A"),
                new Card(Shape.DIAMONDS, "6"),
                new Card(Shape.DIAMONDS, "7"),
                new Card(Shape.DIAMONDS, "8"),
                new Card(Shape.DIAMONDS, "9"),
                new Card(Shape.DIAMONDS, "10"),
                new Card(Shape.DIAMONDS, "J"),
                new Card(Shape.DIAMONDS, "Q"),
                new Card(Shape.DIAMONDS, "K"),
                new Card(Shape.DIAMONDS, "A"),
                new Card(Shape.CLUBS, "6"),
                new Card(Shape.CLUBS, "7"),
                new Card(Shape.CLUBS, "8"),
                new Card(Shape.CLUBS, "9"),
                new Card(Shape.CLUBS, "10"),
                new Card(Shape.CLUBS, "J"),
                new Card(Shape.CLUBS, "Q"),
                new Card(Shape.CLUBS, "K"),
                new Card(Shape.CLUBS, "A"),
                new Card(Shape.SPADES, "6"),
                new Card(Shape.SPADES, "7"),
                new Card(Shape.SPADES, "8"),
                new Card(Shape.SPADES, "9"),
                new Card(Shape.SPADES, "10"),
                new Card(Shape.SPADES, "J"),
                new Card(Shape.SPADES, "Q"),
                new Card(Shape.SPADES, "K"),
                new Card(Shape.SPADES, "A"),
        };
            printObjectArray(shuffle(cards));
//            printObjectArray(deckShift(cards));

    }
    public static Card[] shuffle(Card[] origin) {
        Random index = new Random();
        Card element;
        for (int i = origin.length - 1; i > 0; i--) {
            int j = index.nextInt(i + 1);
            element = origin[i];
            origin[i] = origin[j];
            origin[j] = element;
        }
        return origin;
    }
    public static Card[] deckShift(Card[] origin) {
        Random splitIndex = new Random();
        int length = origin.length;
        int shiftSize = splitIndex.nextInt(2, 35);

        Card[] shifted = new Card[shiftSize];
        System.arraycopy(origin, 0, shifted, 0, shiftSize);
        System.arraycopy(origin, shiftSize, origin, 0, length - shiftSize);
        System.arraycopy(shifted, 0, origin, length - shiftSize, shiftSize);
        return origin;
    }
}
