package com.gamesTheory;

public class TitForTatSuspect implements Suspect {
    private String name;
    private Move previousOpponentsMove;

    public TitForTatSuspect(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Tit for tat " + name;
    }

    @Override
    public String toString() {
        return "TitForTatSuspect{" +
                "name='" + name + '\'' +
                ", previousOpponentsMove=" + previousOpponentsMove +
                '}';
    }

    @Override
    public Move makeMove() {
        if (previousOpponentsMove == null) {
            return Move.COOPERATE;
        }
        if (previousOpponentsMove == Move.COOPERATE) {
            return Move.COOPERATE;
        } else {
            return Move.DEFECT;
        }

    }

    @Override
    public void inform(Move oppenentsMove) {
        previousOpponentsMove = oppenentsMove;
    }
}
