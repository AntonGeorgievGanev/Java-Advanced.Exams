package Exams.E16December2020.bakery;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (capacity > employees.size()){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
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
        builder.append(String.format("Employees working at Bakery %s:", name)).append(System.lineSeparator());
        employees.forEach(e -> {
            builder.append(e).append(System.lineSeparator());
        });
        return builder.toString().trim();
    }

}
