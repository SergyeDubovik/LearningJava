package com.crypto;

public interface Cypher {
    public char[] encode(char[] openText);
    public char[] decode(char[] closedText);
}
