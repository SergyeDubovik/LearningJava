package com.gamesTheory;

public interface Suspect {
    String getName();
    Move makeMove();
    void inform(Move oppenentsMove);
}
