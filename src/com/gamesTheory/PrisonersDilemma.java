package com.gamesTheory;

public class PrisonersDilemma {

    private static final int ROUNDS = 100;
    private static final int POINTS_COOP_COOP = 3;
    private static final int POINTS_DEF_DEF = 1;
    private static final int POINTS_DEF_COOP = 5;

    public static void main(String[] args) {
        Suspect suspect1 = new CooperativeSuspect("Henry");
        Suspect suspect2 = new DefectiveSuspect("Nick");
        GameResult gameResult = processGame(suspect1, suspect2);
        System.out.println(gameResult);

    }

    public static GameResult processGame(Suspect suspect1, Suspect suspect2) {
        int points1 = 0;
        int points2 = 0;
        for (int i = 0; i < ROUNDS; i++) {
            Move move1 = suspect1.makeMove();
            Move move2 = suspect2.makeMove();
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
            suspect1.inform(move2);
            suspect2.inform(move1);
        }
        return new GameResult(suspect1, points1, suspect2, points2);
    }
}
