package com.birhtdayCalculator;

/* As a user I want to run a program, input a birthday date in ISO format and the program will calculate how many times
 my birthday was on Monday, Tuesday, …

E.g. I enter 01.01.2023 and expected output:
Mon: 1
Tue: 0
Wen: 1
Thu: 0
Fri: 0
Sat: 0
Sun: 1

It’s only 3 dates: 01.01.23, 01.01.24 and 01.01.25. And it was a wen, mon and sun.
Another example: I enter 09.08.07 and output something like this (it’s not a correct answer, just example):
Mon: 3
Tue: 2
Wen: 1
Thu: 4
Fri: 2
Sat: 2
Sun: 1
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BirthdayCalculator {
    static int totalBirthdays;
    static LocalDate localDate;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Date of birth (yyyy-mm-dd):");
        String birthdayDate = sc.nextLine();
        LocalDate date = LocalDate.parse(birthdayDate);
        Map<DayOfWeek, Integer> stats = new TreeMap<>();
        for (localDate = date; localDate.isBefore(LocalDate.now()); localDate = localDate.plusYears(1)) {
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            stats.put(dayOfWeek, stats.getOrDefault(dayOfWeek, 0) + 1);
            totalBirthdays++;
        }
        System.out.println();
        System.out.println("This is how many times was your birthday on each weekday:");
        for (DayOfWeek day : stats.keySet()){
            float percent = ((float)stats.get(day) / totalBirthdays) * 100;
            System.out.printf("%-10s %4d (%5.2f%%)%n", day, stats.get(day), percent);
        }

    }
//    создаем мапу, где ключ - день недели, значение - кол-во раз др
//    проходимся циклом от введенной даты до сегодняшнего дня с шагом в 1 год
//    для каждой даты добавляем единичку в соответствующий день недели, в который она припала
//    печатаем мапу


}
