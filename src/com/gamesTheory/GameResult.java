package com.gamesTheory;

public class GameResult {
    private Suspect suspect1;
    private int points1;
    private Suspect suspect2;
    private int points2;

    public GameResult(Suspect suspect1, int points1, Suspect suspect2, int points2) {
        this.suspect1 = suspect1;
        this.suspect2 = suspect2;
        this.points1 = points1;
        this.points2 = points2;
    }

    @Override
    public String toString() {
        return "GameResult:" + '\n' +
                "suspect1 = " + suspect1 +
                ", points1 = " + points1 + '\n' +
                "suspect2 = " + suspect2 +
                ", points2 = " + points2;
    }

    public Suspect getSuspect1() {
        return suspect1;
    }

    public Suspect getSuspect2() {
        return suspect2;
    }

    public int getPoints1() {
        return points1;
    }

    public int getPoints2() {
        return points2;
    }
}
