package Exams.E18August2021.cafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if (capacity > employees.size()){
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        for (Employee employee : employees){
            if (employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
       return employees.stream().sorted(Collections.reverseOrder(Comparator.comparing(Employee::getAge))).collect(Collectors.toList()).get(0);
    }

    public Employee getEmployee(String name){
        for (Employee employee : employees){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Cafe %s:", name)).append(System.lineSeparator());
        for (Employee employee : employees){
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
