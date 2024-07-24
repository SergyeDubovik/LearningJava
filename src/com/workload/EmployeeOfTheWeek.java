package com.workload;

public class EmployeeOfTheWeek {
    public static void main(String[] args) {
        String[] employees = {"John", "Fred", "Gary", "Clark"};
        int expectedGoods = 10;
        int[][] producedGoods = {
                {10, 9, 10, 8, 0, 12, 0},
                {8, 9, 10, 10, 9, 0, 0},
                {5, 5, 4, 5, 4, 11, 8},
                {10, 10, 11, 11, 10, 0, 0},
        };
        System.out.println(findEmployeeOfTheWeek(employees, expectedGoods, producedGoods));

        employees = new String[] {"fail", "success"};
        producedGoods = new int[][] {
                {12, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 11}};
        System.out.println(findEmployeeOfTheWeek(employees, expectedGoods, producedGoods));
    }

    /*
        создаем массив с количеством баллов для каждого работника
        для каждого работника проходим циклом по массиву произведенной продукции
        вычисляем кол-во баллов для каждого работника за каждый день
            если сделано меньше или норма, то начисляем по стандарту баллы
            если сделано больше нормы, то удваиваем баллы, которые сверх нормы
            также удваиваем баллы в выходной
        суммируем вычисленные баллы в новый массив (см. пункт 1)
        находим макс значение в массиве с баллами
        возвращаем имя работника, у которого получилось больше всего баллов

     */
    public static String findEmployeeOfTheWeek(String[] employees, int expGoods, int[][] produced) {
        int[] points = new int[employees.length];
        for (int i = 0; i < produced.length; i++) {
            for (int j = 0; j < produced[i].length; j++) {
                int bonus = 0;
                if (produced[i][j] <= expGoods) {
                    bonus = produced[i][j];
                } else {
                    bonus = expGoods + (produced[i][j] - expGoods) * 2;
                }
                if (j == 5 || j == 6){
                    bonus = produced[i][j] * 2;
                }
                points[i] += bonus;
            }
        }
        int maxValue = Integer.MIN_VALUE;
        int worker = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i] > maxValue) {
                maxValue = points[i];
                worker = i;
            }
        }
        return employees[worker];
    }
}

/*
    люди жалуются, что на выходных им не учитываются баллы, если они перевыполнили норму
 */
