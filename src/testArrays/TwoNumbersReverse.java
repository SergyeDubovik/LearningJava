package testArrays;

public class TwoNumbersReverse {
    public static void main(String[] args) {
        reverseTwoNumbs();
    }

    private static void reverseTwoNumbs() {
        int a = 72;
        int b = 77;

        a = b - a;      // 2
        b = b - a;      // 5
        a = a + b;      // 7
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


}
