package com.crypto;

public abstract class SymmetricCypher implements Cypher {
    @Override
    public char[] decode(char[] closedText) {
        return encode(closedText);
    }
}
