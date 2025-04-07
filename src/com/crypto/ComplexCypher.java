package com.crypto;

// составной шифр (состоит из других более простых шифров)

public class ComplexCypher implements Cypher {
    private Cypher[] cyphers;

    public ComplexCypher(Cypher[] cyphers) {
        this.cyphers = cyphers;
    }

    @Override
    public char[] encode(char[] openText) {
        char[] result = new char[openText.length];
        for (int i = 0; i < openText.length; i++) {
            result[i] = openText[i];
        }
        for (Cypher cypher : cyphers) {
            result = cypher.encode(result);
        }
        return result;
    }

    @Override
    public char[] decode(char[] closedText) {
        char[] result = new char[closedText.length];
        for (int i = 0; i < closedText.length; i++) {
            result[i] = closedText[i];
        }
        for (int i = cyphers.length - 1; i >= 0; i--) {
            result = cyphers[i].decode(result);
        }
        return result;
    }
}
