package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();

    public University(List<Student> students) {
        this.students = students;
    }

    private Student findStudentsById(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }
    public void addEstination(int id, int estination) {
        Student student = findStudentsById(id);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        student.getGrades().add(estination);
    }
    

}
