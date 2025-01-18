package com.inputOutput;

import java.io.*;

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

    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Маша/Downloads/open-meteo.csv");
        readFile(file);

    }

    private static void readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text;
        for (int i = 0; i < 4; i++) {
            br.readLine();
        }
        String temperature;
        while ((text = br.readLine()) != null) {
            int delimeter = text.indexOf(',');
            temperature = text.substring(delimeter + 1);
            System.out.println(temperature);
        }

    }

}
