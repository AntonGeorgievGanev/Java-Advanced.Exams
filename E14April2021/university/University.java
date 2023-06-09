package Exams.E14April2021.university;

import university.Student;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<university.Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<university.Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(university.Student student){
        if (capacity < students.size()){
            return "No seats in the university";
        }

        for (university.Student s : students){
            if (s.equals(student)){
                return "Student is already in the university";
            }
        }
        students.add(student);
        return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
    }

    public String dismissStudent(university.Student student){
        for (university.Student s : students){
            if (s.equals(student)){
                students.remove(s);
                return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return "Student not found";
    }

    public university.Student getStudent(String firstName, String lastName){
        for (Student s : students){
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                return s;
            }
        }
        return null;
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        students.forEach(s -> {
            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", s.getFirstName(), s.getLastName(), s.getBestSubject())).append(System.lineSeparator());
        });
        return builder.toString().trim();
    }
}
