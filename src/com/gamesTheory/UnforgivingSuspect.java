package com.gamesTheory;

public class UnforgivingSuspect  implements Suspect {
    private final String name;
    private Move nextMove;

    public UnforgivingSuspect(String name) {
        this.name = name;
        nextMove = Move.COOPERATE;
    }

    @Override
    public String toString() {
        return "UnforgivingSuspect{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return "Unforgivable " + name;
    }

    @Override
    public Move makeMove() {
        return nextMove;
    }

    @Override
    public void inform(Move oppenentsMove) {
        if (oppenentsMove == Move.DEFECT) {
            nextMove = Move.DEFECT;
        }
    }
}
