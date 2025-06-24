package com.epamTasks.collectionsPractise.studentsGradebook;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class StudentGradebookImpl implements StudentGradebook {
    private Map<Student, Map<String, BigDecimal>> map;
    private final Comparator<Student> comparator;

    public StudentGradebookImpl() {
        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int res = s1.getLastName().compareTo(s2.getLastName());
                if (res != 0) {
                    return res;
                }
                res = s1.getFirstName().compareTo(s2.getFirstName());
                if (res != 0) {
                    return res;
                }
                return s1.getGroup().compareTo(s2.getGroup());
            }
        };
        map = new TreeMap<>(studentComparator);
        this.comparator = studentComparator;

    }

    @Override
    public boolean addEntryOfStudent(Student student, String discipline, BigDecimal grade) {
        Map<String, BigDecimal> grades = map.get(student);
        if (grades == null) {
            grades = new HashMap<>();
            map.put(student, grades);
        }
        if (grades.containsKey(discipline)) {
            return false;
        }
        grades.put(discipline, grade);
        return true;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Comparator<Student> getComparator() {
        return comparator;
    }

    @Override
    public List<String> getStudentsByDiscipline(String discipline) {
        List<String> namesGrades = new ArrayList<>();
        for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
            Student student = entry.getKey();
            Map<String, BigDecimal> grades = entry.getValue();
            if (grades.containsKey(discipline)) {
                BigDecimal grade = grades.get(discipline);
                namesGrades.add(student.getLastName() + "_" + student.getFirstName() + ": " + grade);
            }
        }
        return namesGrades;
    }

    @Override
    public Map<Student, Map<String, BigDecimal>> removeStudentsByGrade(BigDecimal grade) {
        Map<Student, Map<String, BigDecimal>> removed = new TreeMap<>(comparator);
        Iterator<Map.Entry<Student, Map<String, BigDecimal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Student, Map<String, BigDecimal>> entry = iterator.next();
            Map<String, BigDecimal> grades = entry.getValue();
            for (Map.Entry<String, BigDecimal> gradeEntry : grades.entrySet()) {
                BigDecimal currentGrade = gradeEntry.getValue();
                if (currentGrade.compareTo(grade) < 0) {
                    removed.put(entry.getKey(), entry.getValue());
                    iterator.remove();
                    break;
                }
            }
        }
        return removed;
    }

    @Override
    public Map<BigDecimal, List<Student>> getAndSortAllStudents() {
        Map<BigDecimal, List<Student>> average = new TreeMap<>();
        for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
            Student student = entry.getKey();
            Map<String, BigDecimal> grades = entry.getValue();
            BigDecimal sum = BigDecimal.ZERO;
            int count = 0;
            for (BigDecimal grade : grades.values()) {
                sum = sum.add(grade);
                count++;
            }
            BigDecimal averageGrade = sum.divide(BigDecimal.valueOf(count), 1, RoundingMode.HALF_UP);
            if (!average.containsKey(averageGrade)) {
                average.put(averageGrade, new ArrayList<>());
            }
            average.get(averageGrade).add(student);
        }
        return average;
    }

}
