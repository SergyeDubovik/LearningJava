package com.epamTasks;

import java.util.Scanner;

public class GoDutch {
    public static void main(String[] args) {

        /*
            Go Dutch

            Consider a company of friends visiting a restaurant. They decided to equally split the bill.

            Friends decided to add 10 percent of the bill total amount as tips.
            Then they cover the total payment in equal parts.

            Write a program that reads a bill total amount and a number of friends, and then prints part to pay.

            Consider some details:

            Program must read data from System.in

            Bill total amount cannot be negative. If input value is negative, the program stops, printing:
            Bill total amount cannot be negative

            Number of friends cannot be negative or zero. If input value is, then the program stops, printing:
            Number of friends cannot be negative or zero

            Bill total amount, number of friends and part to pay are integers

            Example
            Input:
            1000
            5

            Output:
            220
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sum of bill:");
        int billAmount = scanner.nextInt();
        if (billAmount < 0) {
            System.out.println("Bill total amount cannot be negative");
            return;
        }
        System.out.println("Number of friends:");
        int friends = scanner.nextInt();
        if (friends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }
        int percent = (billAmount * 10) / 100;
        int bill = billAmount + percent;
        int amountToPay = bill / friends;
        System.out.println(amountToPay);
    }
}
