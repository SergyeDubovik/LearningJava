package com.gamesTheory.suspect;

import com.gamesTheory.Move;

public class GivesOutDoubleSuspect implements Suspect {
    private final String name;
    private Move nextMove;
    private Move opponentsMove;

    public GivesOutDoubleSuspect(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GivesOutDoubleSuspect{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return "GivesOutDoubleSuspect " + name;
    }

    @Override
    public Move makeMove() {
        if (opponentsMove == Move.DEFECT) {
            nextMove = Move.DEFECT;
            return Move.DEFECT;
        }
        if (nextMove == Move.DEFECT) {
            nextMove = null;
            return Move.DEFECT;
        }
        return Move.COOPERATE;
    }

    @Override
    public void inform(Move oppenentsMove) {
        this.opponentsMove = oppenentsMove;
    }

    @Override
    public void reset() {
        nextMove = null;
        opponentsMove = null;
    }
}
