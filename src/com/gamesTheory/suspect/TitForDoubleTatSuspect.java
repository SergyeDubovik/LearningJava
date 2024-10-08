package com.gamesTheory.suspect;

import com.gamesTheory.Move;

public class TitForDoubleTatSuspect implements Suspect {
    private final String name;
    private Move lastOpponentsMove;
    private Move secondLastOpponentsMove;

    public TitForDoubleTatSuspect(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TitForDoubleTat {" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return "TitForDoubleTat - " + name;
    }

    @Override
    public Move makeMove() {
        if (lastOpponentsMove == null) {
            return Move.COOPERATE;
        }
        if (lastOpponentsMove == Move.DEFECT && secondLastOpponentsMove == Move.DEFECT) {
            return Move.DEFECT;
        }
        return Move.COOPERATE;
    }

    @Override
    public void inform(Move oppenentsMove) {
        secondLastOpponentsMove = lastOpponentsMove;
        lastOpponentsMove = oppenentsMove;
    }

    @Override
    public void reset() {
        lastOpponentsMove = null;
        secondLastOpponentsMove = null;
    }
}
