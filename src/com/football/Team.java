package com.football;

public class Team {
    public String name;
    public MatchResult[] results;
    private int resultNumber;
    public int score;


    public Team(String name) {
        this.name = name;

    }

    public void addResult(MatchResult result) {
        results[resultNumber] = result;
        resultNumber++;
    }

    public int calculateScore() {
        for (MatchResult result : results) {
            score += result.calculateScore(this);
        }
        return score;
    }



}
