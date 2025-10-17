package com.epamTasks.beginner.classes;

import java.util.List;

public class CarouselRun {
    protected List<Integer> numbers;
    protected int index;

    public CarouselRun(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int next() {
        if (isFinished()) {
            return -1;
        }
        int count = 0;
        while (count < numbers.size()) {
            int currentValue = numbers.get(index);
            if (currentValue > 0) {
                numbers.set(index, currentValue - 1);
                index = (index + 1) % numbers.size();
                return currentValue;
            }
            index = (index + 1) % numbers.size();
            count++;
        }
        return -1;
    }

    public boolean isFinished() {
        for (Integer number : numbers) {
            if (number > 0) {
                return false;
            }
        }
        return true;
    }

}

