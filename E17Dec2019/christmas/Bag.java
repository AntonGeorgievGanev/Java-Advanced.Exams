package Exams.E17Dec2019.christmas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count(){
        return data.size();
    }

    public void add(Present present){
        if (capacity > data.size()){
            data.add(present);
        }
    }

    public boolean remove(String name){
        for (Present present : data){
            if (present.getName().equals(name)){
                data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent(){
        return data.stream().sorted(Collections.reverseOrder(Comparator.comparing(Present::getWeight))).collect(Collectors.toList()).get(0);
    }

    public Present getPresent(String name){
        for (Present present : data){
            if (present.getName().equals(name)){
                return present;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s bag contains:", color)).append(System.lineSeparator());
        data.forEach(p -> {
            builder.append(p).append(System.lineSeparator());
        });
        return builder.toString().trim();
    }
}
