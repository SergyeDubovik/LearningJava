package com.gamesTheory.suspect;

import com.gamesTheory.Move;

public class CooperativeSuspect implements Suspect {

    private final String name;

    public CooperativeSuspect(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CooperativeSuspect {" +
                "name = '" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return "Cooperative - " + name;
    }

    @Override
    public Move makeMove() {
        return Move.COOPERATE;
    }

    @Override
    public void inform(Move oppenentsMove) {
        // ignore
    }

    @Override
    public void reset() {
        // ignore
    }
}
