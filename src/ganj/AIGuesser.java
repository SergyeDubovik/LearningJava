package ganj;

public class AIGuesser implements Guesser {
    private int from;
    private int to;
    private int lastGuess;

    @Override
    public void initialize(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int makeGuess() {
        lastGuess = (from + to) / 2;
        return lastGuess;
    }

    @Override
    public void notifyResult(CompareResult compareResult) {
        if (compareResult == CompareResult.GREATER) {
            System.out.println("Guess number is greater");
            from = lastGuess + 1;
        } else if (compareResult == CompareResult.LOWER) {
            System.out.println("Guess number is lower");
            to = lastGuess - 1;
        } else {
            System.out.println("Congrats, You nailed it!");
        }
    }
}
