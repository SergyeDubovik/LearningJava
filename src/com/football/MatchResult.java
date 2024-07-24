package com.football;

public class MatchResult {
    public Team host;
    public Team guest;
    public int hostGoals;
    public int guestGoals;

    public MatchResult(Team host, Team guest, int hostGoals, int guestGoals) {
        this.host = host;
        this.guest = guest;
        this.hostGoals = hostGoals;
        this.guestGoals = guestGoals;
    }

    public int calculateScore(Team team) {
        if (hostGoals == guestGoals) {
            return 1;
        }
        if ((hostGoals > guestGoals && team == host) || (hostGoals < guestGoals && team == guest)) {
            return 3;
        }
        return 0;
    }
}
