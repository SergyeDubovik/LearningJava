package com.inputOutput;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
//        File file = new File("C:/Users/Сергей/Downloads/open-meteo-40.74N73.91W9m.csv");
        File file = new File("D:/open-meteo-40.74N73.91W9m.csv");
//        File outputData = new File("C:/Users/Сергей/Desktop/max temperature.csv");
        File outputData = new File("D:/max temperature.csv");
//        calculateAverageByYear(file);
        countMaxValue(file, outputData);
    }

    private static Map<Integer, List<Double>> readFile(File file) throws IOException {
//        frame of whole line - 2015-01-01T00:00,-17.2
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text;
        for (int i = 0; i < 4; i++) {
            br.readLine();
        }
        String temperature;
        String date;
        double parsedTemperature;
        Map<Integer, List<Double>> temperatureMap = new TreeMap<>();
        while ((text = br.readLine()) != null) {
            int delimiter = text.indexOf(',');
            temperature = text.substring(delimiter + 1);
            parsedTemperature = Double.parseDouble(temperature);
            date = text.substring(0, delimiter);
            LocalDate wholeDate = LocalDate.parse(date.substring(0, 10));
            int year = wholeDate.getYear();
            List<Double> temperatures = temperatureMap.get(year);
            if (temperatures == null) {
                temperatures = new ArrayList<>();
                temperatureMap.put(year, temperatures);
            }
            temperatures.add(parsedTemperature);
        }
        return temperatureMap;
    }


    private static void calculateAverageByYear(File file) throws IOException {
        Map<Integer, List<Double>> temperatures = readFile(file);
        for (Integer date : temperatures.keySet()) {
            System.out.println(date + ": " + average(temperatures.get(date)));
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

//    посчитать максимальную температуру за год

    private static void countMaxValue(File file, File output) throws IOException {
        Map<Integer, List<Double>> temperature = readFile(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write("Date; Max Temperature");
            writer.newLine();
            for (Integer date : temperature.keySet()) {
                Double maxTemperature = Collections.max(temperature.get(date));
                writer.write((date + ";" + maxTemperature));
                writer.newLine();
            }
        }
    }
/*
    1.1 создаем класс Record, в котором будет два поля, первое поле будет температурой, второе будет датой этой
    температуры
    1.2 когда мы читаем из файла - используем класс Record для обозначения температуры с датой для указанного года
    1.3 для каждого года ищем в списке Record'ов запись с максимальной температурой
    1.4 выводим это всё в консоль
 */

}
