package com.gamesTheory.suspect;

import com.gamesTheory.Move;

public class PeriodicallyDefectSuspect implements Suspect {

    private final String name;
    private int movesCount;
    private final int defectPeriod;
    private final int defectAmount;

    public PeriodicallyDefectSuspect(String name, int defectPeriod, int defectAmount) {
        this.name = name;
        this.defectPeriod = defectPeriod;
        this.defectAmount = defectAmount;
    }

    @Override
    public String toString() {
        return "PeriodicallyDefectSuspect{" +
                "name='" + name + '\'';
    }

    @Override
    public String getName() {
        return "Defect every " + defectPeriod + " move - " + name;
    }

    @Override
    public Move makeMove() {
        movesCount++;
        if (movesCount % defectPeriod < defectAmount) {
            return Move.DEFECT;
        }
        return Move.COOPERATE;

    }

    @Override
    public void inform(Move oppenentsMove) {

    }

    @Override
    public void reset() {
        movesCount = 0;
    }
}
