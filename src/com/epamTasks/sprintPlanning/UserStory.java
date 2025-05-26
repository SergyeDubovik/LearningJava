package com.epamTasks.sprintPlanning;

public class UserStory extends Ticket {
    private UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        dependencies = dependsOn;
    }

    @Override
    public void complete() {
        for (UserStory userStory : dependencies) {
            if (!userStory.isCompleted()) {
                return;
            }
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        UserStory[] copied = new UserStory[dependencies.length];
        System.arraycopy(dependencies, 0, copied, 0, dependencies.length);
        return copied;
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
