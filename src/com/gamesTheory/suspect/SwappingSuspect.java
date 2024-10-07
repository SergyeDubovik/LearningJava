package com.gamesTheory.suspect;

import com.gamesTheory.Move;

public class SwappingSuspect implements Suspect {
    private final String name;
    private final int period;
    private int movesCount;


    public SwappingSuspect(String name, int period) {
        this.name = name;
        this.period = period;
    }

    @Override
    public String toString() {
        return "SwappingSuspect{" +
                "name='" + name + '\'' +
                ", period=" + period +
                '}';
    }

    @Override
    public String getName() {
        return "SwappingSuspect " + "per " + period + " - " + name;
    }

    @Override
    public Move makeMove() {
        movesCount++;
        if (movesCount <= period) {
            return Move.COOPERATE;
        }
        if (movesCount == period * 2) {
            movesCount = 0;
        }
        return Move.DEFECT;
    }

    @Override
    public void inform(Move oppenentsMove) {

    }

    @Override
    public void reset() {
        movesCount = 0;
    }
}
