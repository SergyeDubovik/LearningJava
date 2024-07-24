package com.crypto;

public class LegendaryCypher implements Cypher {
    private int x;

    public LegendaryCypher(int x) {
        this.x = x;
    }

    @Override
    public char[] encode(char[] openText) {
        return new char[0];
    }

    @Override
    public char[] decode(char[] closedText) {
        return new char[0];
    }
}
