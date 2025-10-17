package com.epamTasks.beginner.taskCarousel;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {
    private int capacity;
    private List<Task> tasks;
    private int index = 0;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new ArrayList<>();
    }

    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || isFull()) {
            return false;
        }
        tasks.add(task);
        return true;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        int checked = 0;
        while (checked < tasks.size()) {
            Task currentTask = tasks.get(index);
            if (!currentTask.isFinished()) {
                currentTask.execute();
                if (currentTask.isFinished()) {
                    tasks.remove(index);
                    if (tasks.isEmpty()) {
                        index = 0;
                    } else if (index >= tasks.size()) {
                        index = 0;
                    }
                } else {
                    index = (index + 1) % tasks.size();
                }
                return true;
            } else {
                index = (index + 1) % tasks.size();
                checked++;
            }
        }
        return false;
    }

    public boolean isFull() {
        return tasks.size() >= capacity;
    }

    public boolean isEmpty() {
        for (Task task : tasks) {
            if (!task.isFinished()) {
                return false;
            }
        }
        return true;
    }

}
