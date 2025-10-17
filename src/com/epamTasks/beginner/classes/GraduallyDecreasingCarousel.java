package com.epamTasks.beginner.classes;

/*
    This subclass must decrement elements by gradually increasing decrement.
    When you need to decrement an element for the first time, decrease it by `1`.
    Next time you need to decrement the same element, decrease it by `2`.
    Next time decrease by `3`, then by `4` and so on.
 */

public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run() {
        if (accumulatingState) {
            accumulatingState = false;
            return new GraduallyDecreasingCarouselRun(numbers);
        }
        return null;
    }
}
