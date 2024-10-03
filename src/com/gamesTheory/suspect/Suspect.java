package com.gamesTheory.suspect;

import com.gamesTheory.Move;

public interface Suspect {
    String getName();
    Move makeMove();
    void inform(Move oppenentsMove);
    void reset();
}
