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
        for(int i = 0; i < results.length; i++) {
            score += results[i].calculateScore(this);
        }
        return score;
    }



}
