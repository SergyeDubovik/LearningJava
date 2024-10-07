package com.gamesTheory;

import com.gamesTheory.suspect.*;

public class PrisonersDilemma {
    private static boolean log;
    private static final int ROUNDS = 20;
    private static final int POINTS_COOP_COOP = 3;
    private static final int POINTS_DEF_DEF = 1;
    private static final int POINTS_DEF_COOP = 5;

    public static void main(String[] args) {
        log = false;
        Suspect suspect1 = new CooperativeSuspect("Henry");
        Suspect suspect2 = new DefectiveSuspect("Nick");
        Suspect suspect3 = new PeriodicallyDefectSuspect("Joe", 3, 1);
        Suspect suspect4 = new TitForTatSuspect("Harry");
        Suspect suspect5 = new TitForDoubleTatSuspect("Peter");
        Suspect suspect6 = new SwappingSuspect("Mo", 2);
        Suspect suspect7 = new UnforgivingSuspect("John Wick");
        Suspect suspect8 = new GivesOutDoubleSuspect("Zack");
        Suspect suspect9 = new PeriodicallyDefectSuspect("V", 10, 3);
        Suspect suspect10 = new SwappingSuspect("Seth", 4);
        Suspect suspect11 = new VindictiveSuspect("Tim", 2);
//        GameResult gameResult = processGame(suspect9, suspect11);
//        System.out.println(gameResult);
        processTournament(suspect1, suspect2, suspect3, suspect4, suspect5, suspect6, suspect7, suspect8,
                suspect9, suspect10, suspect11);
    }

    public static void processTournament(Suspect... suspects) {
        int[][] points = new int[suspects.length][suspects.length];
        for (int i = 0; i < suspects.length - 1; i++) {
            for (int j = i + 1; j < suspects.length; j++) {
                GameResult gameResult = processGame(suspects[i], suspects[j]);
                suspects[i].reset();
                suspects[j].reset();
                points[i][j] = gameResult.getPoints1();
                points[j][i] = gameResult.getPoints2();
            }
        }
        int[] totalPoints = new int[suspects.length];
        for (int i = 0; i < suspects.length; i++) {
            totalPoints[i] = sum(points[i]);
            System.out.printf("%-30s %4d%n", suspects[i].getName(), totalPoints[i]);

        }
        System.out.println();
        int championIndex = largestIndex(totalPoints);
        System.out.println("Champion is - " + suspects[championIndex].getName() + " " + totalPoints[championIndex]);
    }

    private static int sum(int[] array) {
        int total = 0;
        for (int j : array) {
            total += j;
        }
        return total;
    }

    private static int largestIndex(int[] array) {
        int largestNumb = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largestNumb) {
                largestNumb = array[i];
                index = i;
            }
        }
        return index;
    }


    public static GameResult processGame(Suspect suspect1, Suspect suspect2) {
        if (log) {
            System.out.println(suspect1.getName() + " | " + suspect2.getName());
        }
        int points1 = 0;
        int points2 = 0;
        for (int i = 0; i < ROUNDS; i++) {
            Move move1 = suspect1.makeMove();
            Move move2 = suspect2.makeMove();
            if (log) {
                System.out.println(i + " " + move1 + " | " + move2);
            }
            if (move1 == Move.COOPERATE && move2 == Move.COOPERATE) {
                points1 += POINTS_COOP_COOP;
                points2 += POINTS_COOP_COOP;
            }
            if (move1 == Move.COOPERATE && move2 == Move.DEFECT) {
                points2 += POINTS_DEF_COOP;
            }
            if (move1 == Move.DEFECT && move2 == Move.COOPERATE) {
                points1 += POINTS_DEF_COOP;
            }
            if (move1 == Move.DEFECT && move2 == Move.DEFECT) {
                points1 += POINTS_DEF_DEF;
                points2 += POINTS_DEF_DEF;
            }
            if (log) {
                System.out.println(points1 + " " + points2);
            }
            suspect1.inform(move2);
            suspect2.inform(move1);
        }
        return new GameResult(suspect1, points1, suspect2, points2);
    }
}
