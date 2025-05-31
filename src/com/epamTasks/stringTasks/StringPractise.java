package com.epamTasks.stringTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringPractise {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample == null || words == null || words.length == 0) {
            return 0;
        }
        int count = 0;
        sample = sample.toLowerCase().strip();
        for (String word : words) {
            if (word.toLowerCase().strip().equals(sample)) {
                count++;
            }
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.isEmpty() || text.matches("[,.;: ?!]*")) {
            return null;
        }
        String[] strings = text.split("[,.;: ?!]+");
        List<String> result = new ArrayList<>();
        for (String word : strings) {
            if (!word.isEmpty()) {
                result.add(word);
            }
        }
        if (result.isEmpty()) {
            return null;
        }
        return result.toArray(new String[0]);
    }

    public static String convertPath(String path, boolean toWin) {
        System.out.println("soon.....");
        throw new UnsupportedOperationException();
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (String string : words) {
            if (string.isEmpty()) {
                continue;
            }
            sj.add(string);
        }
        if (sj.length() == 2) {
            return null;
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}
