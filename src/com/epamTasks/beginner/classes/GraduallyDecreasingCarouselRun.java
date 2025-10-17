package com.epamTasks.beginner.classes;

import java.util.ArrayList;
import java.util.List;

public class GraduallyDecreasingCarouselRun extends CarouselRun {
    protected List<Integer> stepCounter;

    public GraduallyDecreasingCarouselRun(List<Integer> numbers) {
        super(numbers);
        stepCounter = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            stepCounter.add(1);
        }
    }

    @Override
    public int next() {
        if (isFinished()) {
            return -1;
        }
        int count = 0;
        while (count < numbers.size()) {
            int currentValue = numbers.get(index);
            int currentStep = stepCounter.get(index);
            if (currentValue > 0) {
                numbers.set(index, currentValue - currentStep);
                stepCounter.set(index, currentStep + 1);
                index = (index + 1) % numbers.size();
                return currentValue;
            }
            index = (index + 1) % numbers.size();
        }
        return -1;
    }
}
