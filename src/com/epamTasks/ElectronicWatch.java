package com.epamTasks;

import java.util.Scanner;

public class ElectronicWatch {
    /*
    The program must print an electronic watch screen output for a given value of seconds since midnight.
    Input value is given via System.in. Output value must be printed to System.out
    It is guaranteed, that input number is non-negative.
    Output format is h:mm:ss (possible values: [0:00:00; 23:59:59]).
    Extra challenge: try to solve the task without using if statements or cycles.

    Examples:

    Input: 60
    Output: 0:01:00

    Input: 3599
    Output: 0:59:59

    Input: 86229
    Output: 23:57:09

    Input: 86400
    Output: 0:00:00

    Input: 89999
    Output: 0:59:59

    Input: 86460
    Output: 0:01:00
    */

    public static void main(String[] args) {
//        60 sec = 1 min
//        3600 sec = 1 hour
//        24 hours = 3600 * 24
        Scanner scanner = new Scanner(System.in);
        System.out.println("seconds:");
        int seconds = scanner.nextInt();

        int hours = seconds / 3600;
        int minutes = (seconds % 3600 / 60);
        int secs = seconds % 60;
        System.out.printf("%d:%02d:%02d", hours, minutes, secs);
    }
}
