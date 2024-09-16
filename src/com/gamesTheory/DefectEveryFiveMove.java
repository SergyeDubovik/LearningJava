package com.gamesTheory;

public class DefectEveryFiveMove implements Suspect {

    private String name;

    public DefectEveryFiveMove(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DefectEveryFiveMove{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return "Defect every five move " + name;
    }

    @Override
    public Move makeMove() {
        int movesCount = 0;
        movesCount++;
        if (movesCount % 5 == 0) {
            return Move.DEFECT;
        } else {
            return Move.COOPERATE;
        }
    }

    @Override
    public void inform(Move oppenentsMove) {

    }
}
