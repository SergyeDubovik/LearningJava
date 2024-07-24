package com.crypto;

public class SimplePermutationCypher extends SymmetricCypher {
    @Override
    public char[] encode(char[] openText) {
        char[] result = new char[openText.length];
        for (int i = 0; i < openText.length; i++) {
            result[i] = openText[openText.length - 1 - i];
        }
        return result;
    }


}
