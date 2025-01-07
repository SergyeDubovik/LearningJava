package com.collection;

import java.util.*;

public class MapTasks {
    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Math", 5);
        grades.put("Chemistry", 5);
        grades.put("Biology", 3);
        grades.put("German", 4);
        System.out.println(calculateAverageGrade(grades));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(5);
        numbers.add(5);
        numbers.add(5);
        numbers.add(5);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(99);
        numbers.add(7);
        numbers.add(3);
        numbers.add(3);
        numbers.add(5);
        numbers.add(11);
        numbers.add(5);
        numbers.add(7);
        numbers.add(3);
        numbers.add(96);
        System.out.println(calculateNonRepeatingNumbersAmount(numbers));
        System.out.println(countUniqueNumbers(numbers));
    }

//    есть школьный табель в виде мапы: предмет - оценка, посчитать средний балл успеваемости

    private static double calculateAverageGrade(Map<String, Integer> grades) {
        int quantity = 0;
        for (Integer i : grades.values()) {
            quantity += i;
        }
        return (double) quantity / grades.size();
    }

//    дано: список целых чисел, задача - посчитать кол-во неповторяющихся чисел в списке

    private static int calculateNonRepeatingNumbersAmount(List<Integer> numbers) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        for (Integer i : numbers) {
            occurrence.put(i, occurrence.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Integer i : occurrence.values()) {
            if (i == 1) {
                res++;
            }
        }
        return res;
    }

//    дано: список целых чисел, задача - посчитать кол-во уникальных чисел в списке
//   пример: 1 1 2 2 5 7 7 7 (кол-во уникальных - это 4)

    private static int countUniqueNumbers(List<Integer> numbers) {
        Map<Integer, Integer> numbersFromList = new HashMap<>();
        for (Integer i : numbers) {
            numbersFromList.put(i, numbersFromList.get(i));
        }
        return numbersFromList.size();
    }

}
