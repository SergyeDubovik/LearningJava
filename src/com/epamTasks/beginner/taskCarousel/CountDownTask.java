package com.epamTasks.beginner.taskCarousel;

public class CountDownTask implements Task {
    private int value;

    public CountDownTask(int i) {
//        if (i < 0) {
//            this.value = 0;
//        } else {
//            this.value = i;
//        }

//        ↑ this code equals to above one ↑
        this.value = Math.max(i, 0);
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
