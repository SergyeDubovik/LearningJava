package com.gamesTheory;

import com.gamesTheory.suspect.Suspect;

public class TournamentResult {
    private final Suspect[] suspects;
    private final int[] points;

    public TournamentResult(Suspect[] suspects, int[] points) {
        this.suspects = suspects;
        this.points = points;
    }
}
