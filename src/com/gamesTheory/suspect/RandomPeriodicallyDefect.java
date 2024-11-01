package com.gamesTheory.suspect;

import com.gamesTheory.Move;
import com.gamesTheory.NamedSuspect;

import java.util.Random;

public class RandomPeriodicallyDefect extends NamedSuspect {
    private int defectChance;
    private Random randomDefect;


    public RandomPeriodicallyDefect(String name, int defectChance) {
        super(name);
        this.randomDefect = new Random();
        if (defectChance < 0 || defectChance > 100) {
            throw new IllegalArgumentException("defect chance should be more than 0 and less than 101");
        }
        this.defectChance = defectChance;

    }

    @Override
    public String toString() {
        return "RandomPeriodicallyDefect{" +
                "name='" + name + '\'' +
                ", defectPeriod=" + randomDefect +
                ", defectAmount=" + defectChance +
                '}';
    }

    @Override
    public String getName() {
        return "Defect randomly " + name;
    }

    @Override
    public Move makeMove() {
        int percent = randomDefect.nextInt(100) + 1;
        if (percent < defectChance) {
            return Move.DEFECT;
        }
        return Move.COOPERATE;
    }

    @Override
    public void inform(Move oppenentsMove) {

    }

    @Override
    public void reset() {
    }
}
