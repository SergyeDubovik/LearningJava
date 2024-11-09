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
                new Card(Shape.HEARTS, "Jack"),
                new Card(Shape.HEARTS, "Queen"),
                new Card(Shape.HEARTS, "King"),
                new Card(Shape.HEARTS, "Ace"),
                new Card(Shape.DIAMONDS, "6"),
                new Card(Shape.DIAMONDS, "7"),
                new Card(Shape.DIAMONDS, "8"),
                new Card(Shape.DIAMONDS, "9"),
                new Card(Shape.DIAMONDS, "10"),
                new Card(Shape.DIAMONDS, "Jack"),
                new Card(Shape.DIAMONDS, "Queen"),
                new Card(Shape.DIAMONDS, "King"),
                new Card(Shape.DIAMONDS, "Ace"),
                new Card(Shape.CLUBS, "6"),
                new Card(Shape.CLUBS, "7"),
                new Card(Shape.CLUBS, "8"),
                new Card(Shape.CLUBS, "9"),
                new Card(Shape.CLUBS, "10"),
                new Card(Shape.CLUBS, "Jack"),
                new Card(Shape.CLUBS, "Queen"),
                new Card(Shape.CLUBS, "King"),
                new Card(Shape.CLUBS, "Ace"),
                new Card(Shape.SPADES, "6"),
                new Card(Shape.SPADES, "7"),
                new Card(Shape.SPADES, "8"),
                new Card(Shape.SPADES, "9"),
                new Card(Shape.SPADES, "10"),
                new Card(Shape.SPADES, "Jack"),
                new Card(Shape.SPADES, "Queen"),
                new Card(Shape.SPADES, "King"),
                new Card(Shape.SPADES, "Ace"),
        };
//            printObjectArray(shuffle(cards));
            printObjectArray(deckShift(cards));

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
        Random random = new Random();
        int length = origin.length;
        int shiftSize = random.nextInt(2, 35);

        Card[] shifted = new Card[shiftSize];
        System.arraycopy(origin, 0, shifted, 0, shiftSize);
        System.arraycopy(origin, shiftSize, origin, 0, length - shiftSize);
        System.arraycopy(shifted, 0, origin, length - shiftSize, shiftSize);
        return origin;
    }
}
