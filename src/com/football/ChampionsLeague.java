package com.football;

public class ChampionsLeague {
    public static void main(String[] args) {
        String[] group = {"Roma", "AtMadrid", "Bayer", "Liver"};
        int[][] homeMatches = {{-1, 3, 3, 2},
                               {2, -1, 5, 1},
                               {0, 1, -1, 2},
                               {1, 2, 3, -1},};

        int[][] guestMatches = {{-1, 1, 2, 3},
                                {0, -1, 2, 1},
                                {0, 1, -1, 2},
                                {3, 2, 3, -1},};
        System.out.println(winnerGroup(group, homeMatches, guestMatches));
        System.out.println(winnerGroupOOP(group, homeMatches, guestMatches));
    }

    public static String winnerGroup(String[] clGroup, int[][] home, int [][] guest) {
        int[] scores = new int[clGroup.length];
        for (int i = 0; i < clGroup.length; i++) {
            for (int j = 0; j < clGroup.length; j++) {
                if (j == i) {
                    continue;
                }
                if (home[i][j] > home[j][i]) {
                    scores[i] += 3;
                }
                if (home[i][j] == home[j][i]) {
                    scores[i] += 1;
                }
                if (guest[i][j] > guest[j][i]) {
                    scores[i] += 3;
                }
                if (guest[i][j] == guest[j][i]) {
                    scores[i] += 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;
        int winnerNumber = -1;
        for (int i = 0; i < clGroup.length; i++) {
            if (scores[i] > result) {
                result = scores[i];
                winnerNumber = i;
            }
        }
        return clGroup[winnerNumber];
    }

    public static String winnerGroupOOP(String[] clGroup, int[][] home, int [][] guest) {
        Team[] teams = new Team[clGroup.length];
        for(int i = 0; i < clGroup.length; i++) {
            teams[i] = new Team(clGroup[i]);
            teams[i].results = new MatchResult[(clGroup.length - 1) * 2];
        }
        for(int i = 0; i < clGroup.length - 1; i++) {
            for(int j = i + 1; j < clGroup.length; j++) {
                MatchResult homeResult = new MatchResult(teams[i], teams[j], home[i][j], home[j][i]);
                MatchResult guestResult = new MatchResult(teams[j], teams[i], guest[j][i], guest[i][j]);
                teams[i].addResult(homeResult);
                teams[j].addResult(homeResult);
                teams[j].addResult(guestResult);
                teams[i].addResult(guestResult);
            }
        }
        Team winner = null;
        for (int i = 0; i < teams.length; i++) {
            int score = teams[i].calculateScore();
            if (winner == null || winner.score < score) {
                winner = teams[i];
            }
        }
        return winner.name;
    }
}

