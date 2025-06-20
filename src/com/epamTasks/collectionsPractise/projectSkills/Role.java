package com.epamTasks.collectionsPractise.projectSkills;

import java.util.EnumSet;
import java.util.Set;

public class Role {
    private final Level level;

    private final Position position;

    private final Set<Skill> skills;

    public Role(Position position, Level level, Skill... skills) {
        this.position = position;
        this.level = level;
        this.skills = EnumSet.noneOf(Skill.class);
        for (Skill skill : skills) {
            this.skills.add(skill);
        }
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public Level getLevel() {
        return level;
    }

    public Position getPosition() {
        return position;
    }

}
