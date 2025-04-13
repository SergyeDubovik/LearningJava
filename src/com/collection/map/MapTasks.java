package com.collection.map;

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

        List<Integer> myList = new ArrayList<>();
        myList.add(3);
        myList.add(1);
        myList.add(5);

        System.out.println(calculateNonRepeatingNumbersAmount(numbers));
        System.out.println(countUniqueNumbers(numbers));
        System.out.println(containsDuplicate(numbers));
        System.out.println(containsDuplicate(myList));
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
        Set<Integer> numbersFromList = new HashSet<>(numbers);
        return numbersFromList.size();
    }

//    Given an integer list numbers, return true if any value appears at least twice in the list,
//    and return false if every element is distinct.

    private static boolean containsDuplicate(List<Integer> numbers) {
//        Map<Integer, Integer> result = new HashMap<>();
//        for (Integer i : numbers) {
//            result.put(i, result.getOrDefault(i, 0) + 1);
//            if (result.get(i) > 1) {
//                return true;
//            }
//        }
//        return false;
        Set<Integer> result = new HashSet<>();
        for (Integer i : numbers) {
            if (!result.add(i)) {
                return true;
            }
        }
        return false;
    }

}
