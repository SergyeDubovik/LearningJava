package com.epamTasks.taskCarousel;

public class CountDownTask implements Task {
    private int value;

    public CountDownTask(int i) {
        if (i < 0) {
            this.value = 0;
        } else {
            this.value = i;
        }
    }

    public int getValue() {
        return value;
    }


    @Override
    public void execute() {
        if (value > 0) {
            value--;
        }
    }

    @Override
    public boolean isFinished() {
        return value == 0;
    }
}
