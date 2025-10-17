package com.epamTasks.beginner.collectionsPractise.projectSkills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Project {
    private List<Role> roles;

    private static class Entry {
        private Level level;
        private Skill skill;

        public Entry(Level level, Skill skill) {
            this.level = level;
            this.skill = skill;
        }

        @Override
        public int hashCode() {
            return 31 * level.hashCode() + skill.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry other = (Entry) obj;
            return level == other.level && skill == other.skill;
        }

        @Override
        public String toString() {
            return "Entry: " +
                    "level = " + level +
                    ", skill = " + skill;
        }
    }

    public Project(Role... roles) {
        this.roles = new ArrayList<>(Arrays.asList(roles));
    }

    public int getConformity(Set<Member> team) {
        List<Entry> projEntries = new ArrayList<>();
        for (Role role : roles) {
            for (Skill skill : role.getSkills()) {
                projEntries.add(new Entry(role.getLevel(), skill));
            }
        }
        int listSize = projEntries.size();

        List<Entry> teamEntries = new ArrayList<>();
        for (Member member : team) {
            for (Skill skill : member.getSkills()) {
                teamEntries.add(new Entry(member.getLevel(), skill));
            }
        }
        List<Entry> commonEntries = new ArrayList<>(teamEntries);
        int match = 0;
        for (Entry entry : projEntries) {
            if (commonEntries.contains(entry)) {
                match++;
                commonEntries.remove(entry);
            }
        }
        return match * 100 / listSize;
    }

    public List<Role> getRoles() {
        return roles;
    }

}
