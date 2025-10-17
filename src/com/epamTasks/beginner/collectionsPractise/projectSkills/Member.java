package com.epamTasks.beginner.collectionsPractise.projectSkills;

import java.util.EnumSet;
import java.util.Set;

public class Member {
    private String name;

    private Level level;

    private Set<Skill> skills;

    public Member(String name, Level level, Skill... skills) {
        this.name = name;
        this.level = level;
        this.skills = EnumSet.noneOf(Skill.class);
        for (Skill skill : skills) {
            this.skills.add(skill);
        }
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public Set<Skill> getSkills() {
        return skills;
    }


}
