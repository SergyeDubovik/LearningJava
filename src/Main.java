import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        taskDoWhile();
    }

    private static void taskWhile() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number 5, please...");
        int value = scan.nextInt();
        while (value != 5) {
            System.out.println("Input number 5, please...");
            value = scan.nextInt();
        }
        System.out.println("Thank you");
    }

    private static void taskDoWhile() {
        Scanner scan2 = new Scanner(System.in);
        int value2;
        do {
            System.out.println("Input number 5, please...");
            value2 = scan2.nextInt();
        } while (value2 != 5);

        System.out.println("Thank you");
    }
}