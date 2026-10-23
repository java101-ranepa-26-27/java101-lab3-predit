package ru.ranepa;

public class Main {

    public static void main(String[] args) {
        Student student = Student.create("Иванов Иван");
        student.getGrades().add(4);
        student.getGrades().add(5);
        System.out.println(student.average());
        student.printReport();

        University university = new University();

        long id1 = university.enrollStudent("Иванов Иван");
        long id2 = university.enrollStudent("Петров Александр");
        long id3 = university.enrollStudent("Предит Иван");

        university.addGrade(id1, 4);
        university.addGrade(id1, 5);
        university.transferToNextCourse(id1);

        university.addGrade(id2, 2);
        university.addGrade(id2, 3);
        university.transferToNextCourse(id2);

        university.addGrade(id3, 5);
        university.addGrade(id3, 5);
        university.transferToNextCourse(id3);
        university.transferToNextCourse(id3);
        university.transferToNextCourse(id3);
        university.transferToNextCourse(id3);

        try {
            university.addGrade(id2, 4);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Ожидаемый отказ:" + e.getMessage());
        }

        university.printSummary();
    }
}
