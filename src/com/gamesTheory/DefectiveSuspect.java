package com.gamesTheory;

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
        return "defect suspect";
    }

    @Override
    public Move makeMove() {
        return Move.DEFECT;
    }

    @Override
    public void inform(Move oppenentsMove) {
        // ignore
    }
}
