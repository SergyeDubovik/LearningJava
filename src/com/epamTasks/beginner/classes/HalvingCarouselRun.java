package com.epamTasks.beginner.classes;

import java.util.List;

public class HalvingCarouselRun extends CarouselRun {
    public HalvingCarouselRun(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public int next() {
        if (isFinished()) {
            return -1;
        }
        int count = 0;
        while (count < numbers.size()) {
            int currentValue = numbers.get(index);
            if (currentValue > 0) {
                numbers.set(index, currentValue / 2);
                index = (index + 1) % numbers.size();
                return currentValue;
            }
            index = (index + 1) % numbers.size();
            count++;
        }
        return -1;
    }
}
