package com.epamTasks.beginner.taskCarousel;

public class CompleteByRequestTask implements Task {
    private boolean completedByRequest = false;
    private boolean finished = false;
    public CompleteByRequestTask() {
    }

    @Override
    public void execute() {
        if (completedByRequest) {
            finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void complete() {
        completedByRequest = true;
    }
}
