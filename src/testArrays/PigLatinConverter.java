package testArrays;

import java.util.ArrayList;
import java.util.List;

public class PigLatinConverter {

    private static final String VOWELS = "aeiouy";

    public static void main(String[] args) {
        String origin = "Hello world from Italy uncle";
        String[] words = origin.split(" ");
        List<String> pigLatinWords = new ArrayList<>();
        for (String word : words) {
            pigLatinWords.add(convert(word));
        }
        String pigLatin = String.join(" ", pigLatinWords);
        System.out.println(pigLatin);
    }

    private static String convert(String word) {
        char firstLetter = word.charAt(0);
        String firstLetterString = Character.toString(firstLetter);
        if (VOWELS.contains(firstLetterString.toLowerCase())) {
            return word + "-hay";
        } else {
            return word.substring(1) + "-" + firstLetter + "ay";
        }
    }
}
