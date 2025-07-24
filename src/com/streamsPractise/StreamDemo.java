package com.streamsPractise;

import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        streamTest();
    }

    /**
        creates an immutable list
        -> filters words that contains only letters from 'a' to 'p'
        -> extracts the third character from each filtered words (charAt(2))
        -> prints the resulting list of characters to console
     */
    private static void streamTest() {
        List<String> words = List.of("john", "jack", "phillip", "antoni", "pit");
        List<Character> result = words.stream()
                .filter(w -> w.matches("[a-p]+"))
                .map(w -> w.charAt(2))
                .toList();
        System.out.println(result);
    }
}
