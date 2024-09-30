package com.gamesTheory;

public class TitForDoubleTatSuspect implements Suspect {
    private String name;
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
        return "TitForDoubleTat suspect" + name;
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
}
