package com.epamTasks;

import java.util.Scanner;

public class PizzaSplit {

    /*
            Pizza Split

            The program must read two values from System.in:

            number of people;
            number of pieces per pizza.

            It is guaranteed that these values are positive integers.

            Then the program must print the minimum number of pizzas (not zero)
            so that everyone has an equal number of slices and no slice is left.

            Example
            Input: 12 8

            Output: 3
         */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("People:");
        int people = scanner.nextInt();
        if (people < 0) {
            return;
        }
        System.out.println("Slices:");
        int pizzaPieces = scanner.nextInt();
        if (pizzaPieces < 0) {
            return;
        }
        int gcd = findGCD(people, pizzaPieces);
        int lcm = (people * pizzaPieces) / gcd;
        int pizzas = lcm / pizzaPieces;
        System.out.println(pizzas);
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
