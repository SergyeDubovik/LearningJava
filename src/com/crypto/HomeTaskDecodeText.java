package com.crypto;

public class HomeTaskDecodeText implements Cypher {
    private int key;

    public HomeTaskDecodeText(int key) {
        this.key = key;
    }

    @Override
    public char[] encode(char[] openText) {
        key = 7;
        return new char[0];

    }

    @Override
    public char[] decode(char[] closedText) {
        char[] result = new char[closedText.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char)(closedText[i] - key);
            if (result[i] < 'a' && ('a' <= closedText[i] && closedText[i] <= 'z')) {
                result[i] += 26;
            } else if ('A' <= closedText[i] && closedText[i] <= 'Z'
                    && result[i] < 'A') {
                result[i] += 26;
            }
        }
        return result;
    }
}
