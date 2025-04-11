package ganj;

import java.util.Scanner;

public class HumanRiddleMaker implements RiddleMaker {
    private int secretNumber;
    @Override
    public void thinkOfNumberBetween(int from, int to) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Let's guess a number from " + from + " to " + to);
            secretNumber = Integer.parseInt(scanner.nextLine());
            if (secretNumber < from || secretNumber > to) {
                System.out.println("Entered number is out of range!");
            } else {
                break;
            }
        }
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
