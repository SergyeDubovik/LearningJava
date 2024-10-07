package com.gamesTheory.suspect;

import com.gamesTheory.Move;

public class DefectiveSuspect implements Suspect {
    private String name;

    public DefectiveSuspect(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DefectiveSuspect {" +
                "name = '" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return "Defect - " + name;
    }

    @Override
    public Move makeMove() {
        return Move.DEFECT;
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
