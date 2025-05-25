package com.epamTasks.classes;

/*
    In this exercise you need to extend DecrementingCarousel. You need to implement HalvingCarousel.
    This subclass must halve elements instead of decrementing it by one.
    Note that you need to apply regular integer division, discarding the remainder. For example, 5 / 2 = 2.
 */

public class HalvingCarousel  extends DecrementingCarousel {
    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run() {
        if (accumulatingState) {
            accumulatingState = false;
            return new HalvingCarouselRun(numbers);
        }
        return null;
    }
}
