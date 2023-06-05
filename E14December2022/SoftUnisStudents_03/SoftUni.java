package SoftUnisStudents_03;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount(){
        return this.data.size();
    }

    public String insert(Student student){
        String result;
        if (capacity < data.size()){
            result = ("The hall is full.");
        }else if (data.contains(student)){
            result = ("Student is already in the hall.");
        }else{
            data.add(student);
            result = String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }
        return result;
    }

    public String remove(Student student){
        String result;
        if (data.contains(student)){
            data.remove(student);
            result = String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }else{
            result = ("Student not found.");
        }
        return result;
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : data){
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return student;
            }
        }
        return getStudent(firstName, lastName);
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Hall size: %d", data.size())).append(System.lineSeparator());
        for (Student student : data){
            builder.append(student);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
