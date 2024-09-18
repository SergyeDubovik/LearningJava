package com.gamesTheory;

public class PeriodicallyDefectSuspect implements Suspect {

    private String name;
    private int movesCount;
    private int defectPeriod;

    public PeriodicallyDefectSuspect(String name, int defectPeriod) {
        this.name = name;
        this.defectPeriod = defectPeriod;
    }

    @Override
    public String toString() {
        return "PeriodicallyDefectSuspect{" +
                "name='" + name + '\'';
    }

    @Override
    public String getName() {
        return "Defect every " + defectPeriod + " move " + name;
    }

    @Override
    public Move makeMove() {
        movesCount++;
        if (movesCount % defectPeriod == 0) {
            return Move.DEFECT;
        }
        return Move.COOPERATE;

    }

    @Override
    public void inform(Move oppenentsMove) {

    }
}
