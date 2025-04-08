package ganj;

import java.util.Random;

public class AIRiddleMaker implements RiddleMaker {
    private int secretNumber;

    @Override
    public void thinkOfNumberBetween(int from, int to) {
        Random random = new Random();
        secretNumber = random.nextInt(from, to + 1);
    }
    @Override
    public CompareResult check(int number) {
        if (number == secretNumber) {
            return CompareResult.EQUAL;
        } else if (number > secretNumber) {
            return CompareResult.LOWER;
        }
        return CompareResult.GREATER;
    }
}
