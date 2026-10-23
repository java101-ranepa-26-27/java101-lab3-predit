package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();

    public University() {
    }

    private Student findStudentsById(long id) {
        for (Student student : students) {
            if (student.getStudentID() == id) {
                return student;
            }
        }
        throw new IllegalArgumentException("Student not found");
    }

    public long enrollStudent(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }

        Student student = Student.create(name);
        students.add(student);

        return student.getStudentID();
    }

    public void addGrade(long id, int grade) {
        Student student = findStudentsById(id);

        if (student.getState() !=State.ACTIVE) {
            throw new IllegalArgumentException("Student is not active");
        }

        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Grade must be from 2 to 5");
        }

        student.getGrades().add(grade);
    }

    public void unbookStudent(long id) {
        Student student = findStudentsById(id);

        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Student is not active");
        }

        student.setState(State.DISMISSED);
    }
    public void transferToNextCourse(long id) {
        Student student = findStudentsById(id);

        if (student.getState() !=  State.ACTIVE) {
            throw new IllegalArgumentException("Student is not active");
        }

        if (student.average()  <= 2.5) {
            System.out.println("Student expelled");
            student.setState(State.DISMISSED);
            return;
        }

        if (student.getCourse() == 4) {
            student.setState(State.GRADUATED);
        }
        else {
            student.setCourse(student.getCourse() + 1);
        }
    }
    public  void printSummary() {
        for (Student student : students) {
            System.out.println("Student ID:" + student.getStudentID());
            student.printReport();
            System.out.println("Course:" + student.getCourse());
            System.out.println("State:" + student.getState());
            System.out.println("---------");
        }
    }
}
