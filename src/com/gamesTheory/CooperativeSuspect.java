package com.gamesTheory;

public class CooperativeSuspect implements Suspect {

    private String name;

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
        return "cooperative suspect " + name;
    }

    @Override
    public Move makeMove() {
        return Move.COOPERATE;
    }

    @Override
    public void inform(Move oppenentsMove) {
        // ignore
    }
}
