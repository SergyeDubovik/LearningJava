package com.football;

public class WorldCup {
    public static void main(String[] args) {
        String[] teams = {"Italy", "England", "Argentina", "France"};
        int[][] res = {
                {-1, 7, 1, 2},
                {1, -1, 3, 2},
                {1, 3, -1, 4},
                {0, 1, 2, -1}};

        System.out.println(winner(teams, res));
        System.out.println(winnerOOP(teams, res));

    }


    public static String winner(String[] teams, int[][] results) {
        int[] score = new int[teams.length];
        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams.length; j++) {
                if (i == j) {
                    continue;
                }
                if (results[i][j] > results[j][i]) {
                    score[i] += 3;
                }
                if (results[i][j] == results[j][i]) {
                    score[i] += 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;
        int teamNumber = -1;
        for (int i = 0; i < score.length; i++) {
            if (score[i] > result) {
                result = score[i];
                teamNumber = i;
            }
        }
        return teams[teamNumber];
    }

    public static String winnerOOP(String[] teamNames, int[][] results) {
        Team[] teams = new Team[teamNames.length];
        for(int i = 0; i < teamNames.length; i++) {
            teams[i] = new Team(teamNames[i]);
            teams[i].results = new MatchResult[teamNames.length - 1];
        }
        for(int i = 0; i < teamNames.length - 1; i++) {
            for(int j = i + 1; j < teamNames.length; j++) {
                MatchResult result = new MatchResult(teams[i], teams[j], results[i][j], results[j][i]);
                teams[i].addResult(result);
                teams[j].addResult(result);
            }
        }
        Team winner = null;
        for (Team team : teams) {
            int score = team.calculateScore();
            if (winner == null || winner.score < score) {
                winner = team;
            }
        }
        return winner.name;
    }

    /*
        расчитать победителя группы с удвоенным кол-вом матчей (дома и на выезде)
     */
}
