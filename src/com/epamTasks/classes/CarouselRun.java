package com.epamTasks.classes;

import java.util.List;

public class CarouselRun {
    private List<Integer> numbers;
    private int index;

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
                int result = currentValue;
                index = (index + 1) % numbers.size();
                return result;
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

