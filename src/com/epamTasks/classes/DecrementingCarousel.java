package com.epamTasks.classes;

import java.util.ArrayList;
import java.util.List;

public class DecrementingCarousel {
    protected List<Integer> numbers = new ArrayList<>();
    private int capacity;
    protected boolean accumulatingState = true;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
    }

    public boolean addElement(int element) {
        if (element <= 0) {
            return false;
        }
        if (numbers.size() >= capacity) {
            return false;
        }
        if (!accumulatingState) {
            return false;
        }
        numbers.add(element);
        return true;
    }

    public CarouselRun run() {
        if (accumulatingState) {
            accumulatingState = false;
            return new CarouselRun(numbers);
        }
        return null;
    }
}
