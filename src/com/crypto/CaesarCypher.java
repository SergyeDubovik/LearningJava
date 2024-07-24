package com.crypto;

public class CaesarCypher implements Cypher {
    private int n;
    public CaesarCypher(int key) {
        n = key;
    }

    @Override
    public char[] encode(char[] openText) {
        char[] result = new char[openText.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char)(openText[i] + n);
            if (result[i] > 'z') {
                result[i] -= 26;
            } else if (openText[i] >= 'A' && openText[i] <= 'Z'
                        && result[i] > 'Z') {
                result[i] -= 26;
            }
        }
        return result;
    }

    @Override
    public char[] decode(char[] closedText) {
        char[] result = new char[closedText.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char)(closedText[i] - n);
            if (result[i] < 'a' && ('a' <= closedText[i] && closedText[i] <= 'z')) {
                result[i] += 26;
            } else if ('A' <= closedText[i] && closedText[i] <= 'Z'
                    && result[i] < 'A') {
                result[i] += 26;
            }
        }
        return result;
    }

    /*
        1 реализовать дешифрование в цезаре
        2 добавить поддержку больших букв
     */
}
