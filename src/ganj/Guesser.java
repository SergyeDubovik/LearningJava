package ganj;

public interface Guesser {
    void initialize(int from, int to);
    int makeGuess();
    void notifyResult(CompareResult cr);
}
