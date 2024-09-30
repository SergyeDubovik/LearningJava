package com.gamesTheory;

public class PrisonersDilemma {
    private static boolean log;
    private static final int ROUNDS = 10;
    private static final int POINTS_COOP_COOP = 3;
    private static final int POINTS_DEF_DEF = 1;
    private static final int POINTS_DEF_COOP = 5;

    public static void main(String[] args) {
        log = true;
        Suspect suspect1 = new CooperativeSuspect("Henry");
        Suspect suspect2 = new DefectiveSuspect("Nick");
        Suspect suspect3 = new PeriodicallyDefectSuspect("Joe", 5);
        Suspect suspect4 = new TitForTatSuspect("Harry");
        Suspect suspect5 = new TitForDoubleTatSuspect("Joe");
        Suspect suspect6 = new SwappingSuspect("Mo", 2);
        Suspect suspect7 = new UnforgivingSuspect("Mort");
        GameResult gameResult = processGame(suspect3, suspect7);
        System.out.println(gameResult);
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
