package com.epamTasks.collectionsPractise.studentsGradebook;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface StudentGradebook {
    boolean addEntryOfStudent(Student student, String discipline, BigDecimal grade);

    int size();

    Comparator<Student> getComparator();

    List<String> getStudentsByDiscipline(String discipline);

    Map<Student, Map<String, BigDecimal>> removeStudentsByGrade(BigDecimal grade);

    Map<BigDecimal, List<Student>> getAndSortAllStudents();


}
