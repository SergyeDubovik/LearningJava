package com.birhtdayCalculator;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LifetimeCalculator {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Сергей/Downloads/US_presidents.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        List<Person> persons = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length != 6) {
                continue;
            }
            String name = parts[1].trim();
            String date = parts[2].substring(1) + parts[3].substring(0, parts[3].length() - 1);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM d u", Locale.ENGLISH);
            LocalDate birthDate = LocalDate.parse(date.trim(), dateFormatter);
            date = parts[4].substring(1) + parts[5].substring(0, parts[5].length() - 1);
            LocalDate deathDate = LocalDate.parse(date.trim(), dateFormatter);
            persons.add(new Person(name, birthDate, deathDate));
        }
        Map<DayOfWeek, List<Long>> lifespansByDay = new HashMap<>();
        Set<String> names = new HashSet<>();
        for (Person person : persons) {
            if (names.contains(person.getName())) {
                continue;
            } else {
                names.add(person.getName());
            }
            DayOfWeek dayOfWeek = person.birth.getDayOfWeek();
            long lifespan = ChronoUnit.DAYS.between(person.birth, person.death);
            // 1 проверить, есть ли в мапе ключ, (dayOfWeek)
            // 2 если да, то добавляем новый элемент lifespan к этому значению (в список, ассоциированный с этим ключом)
            // 3 если нет, добавляем этот ключ и список из одного элемента
            if (lifespansByDay.containsKey(dayOfWeek)) {
                // получаем список по ключу dayOfWeek и добавляем элемент в список по этому ключу
                lifespansByDay.get(dayOfWeek).add(lifespan);
            } else {
                List<Long> lifespans = new ArrayList<>();
                lifespans.add(lifespan);
                lifespansByDay.put(dayOfWeek, lifespans);
            }
        }
        for (Map.Entry<DayOfWeek, List<Long>> entry : lifespansByDay.entrySet()) {
            System.out.printf("%-10s %.2f years%n", entry.getKey(), average(entry.getValue()));
        }
    }

    private static double average(List<Long> numbers) {
        double sum = 0;
        for (Long l : numbers) {
            sum += l;
        }
        return (sum / numbers.size()) / 365;
    }

    private static class Person {
        String name;
        LocalDate birth;
        LocalDate death;

        public Person(String name, LocalDate birth, LocalDate death) {
            this.name = name;
            this.birth = birth;
            this.death = death;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", birth=" + birth +
                    ", death=" + death +
                    "}\n";
        }

        public String getName() {
            return name;
        }
    }

}
