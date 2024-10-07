package com.gamesTheory.suspect;

import com.gamesTheory.Move;

public class VindictiveSuspect implements Suspect {
    private final String name;
    private int defectCount;
    private final int revengeSize;

    public VindictiveSuspect(String name, int revengeSize) {
        this.name = name;
        this.revengeSize = revengeSize;
    }

    @Override
    public String getName() {
        return "Vindictive - " + name;
    }

    @Override
    public Move makeMove() {
        if (defectCount == 0) {
            return Move.COOPERATE;
        }
        defectCount--;
        return Move.DEFECT;
    }

    @Override
    public void inform(Move oppenentsMove) {
        if (oppenentsMove == Move.DEFECT) {
            defectCount += revengeSize;
        }
    }

    @Override
    public void reset() {
        defectCount = 0;
    }
}
