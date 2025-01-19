package com.inputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Weather {

//    посчитать среднюю температуру за год за последние 10 лет из файла (учесть високосные года**)
//    алгоритм:
//              1.1 прочитать файл и проигнорировать первые 4 строчки
//              1.2 построчно считываем файл, вырезаем из строки всё, что после запятой
//              1.3 преобразуем в число то, что осталось
//              1.4 добавляем число в список
//              1.5 берем первые (24*365) элементов, считаем по ним среднее и выводим на экран
//              1.6 повторяем для следующих 24*365 элементов
//              1.7 бонус - высчитать температуру харькова также
    private static final int MEASUREMENTS_PER_YEAR = 24 * 365;

    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Сергей/Downloads/open-meteo-40.74N73.91W9m.csv");
        calculateAverageByYear(file);
    }

    private static List<Double> readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text;
        for (int i = 0; i < 4; i++) {
            br.readLine();
        }
        String temperature;
        double result;
        List<Double> degreesCelsius = new ArrayList<>();
        while ((text = br.readLine()) != null) {
            int delimiter = text.indexOf(',');
            temperature = text.substring(delimiter + 1);
            result = Double.parseDouble(temperature);
            degreesCelsius.add(result);
        }
        return degreesCelsius;
    }

    private static void calculateAverageByYear(File file) throws IOException {
        List<Double> temperatures = readFile(file);
        List<List<Double>> temperaturesByYear = split(temperatures);
        for (List<Double> numbers : temperaturesByYear) {
            System.out.println(average(numbers));
        }
    }

    private static List<List<Double>> split(List<Double> degrees) {
        int wholeCount = degrees.size();
        int sumYears = wholeCount / MEASUREMENTS_PER_YEAR;
        List<List<Double>> temperatureByYear = new ArrayList<>();
        for (int i = 0; i < sumYears; i++) {
            List<Double> oneYear = new ArrayList<>(degrees.subList(MEASUREMENTS_PER_YEAR * i,
                    MEASUREMENTS_PER_YEAR * (i + 1)));
            temperatureByYear.add(oneYear);
        }
        return temperatureByYear;
    }


    // calculating average from specified piece of list
    private static double average(List<Double> numbers) {
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum / numbers.size();
    }

}
