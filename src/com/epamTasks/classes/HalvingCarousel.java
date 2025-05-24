package com.epamTasks.classes;

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
