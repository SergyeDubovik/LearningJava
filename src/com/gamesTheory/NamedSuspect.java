package com.gamesTheory;

import com.gamesTheory.suspect.Suspect;

public abstract class NamedSuspect implements Suspect {
    protected String name;

    public NamedSuspect(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
