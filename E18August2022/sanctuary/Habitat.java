package sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){
        if (capacity > data.size()){
            data.add(elephant);
        }
    }

    public boolean remove(String name){
        for (Elephant elephant : data){
            if (elephant.getName().equals(name)){
                data.remove(elephant);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom){
        for (Elephant elephant : data){
            if (elephant.getRetiredFrom().equals(retiredFrom)){
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant(){
        return data.stream().sorted(Collections.reverseOrder(Comparator.comparing(Elephant::getAge))).collect(Collectors.toList()).get(0);
    }

    public int getAllElephants(){
        return data.size();
    }

    public String getReport(){
        StringBuilder builder = new StringBuilder();
        builder.append("Saved elephants in the park:");
        for (Elephant elephant : data){
            builder.append(System.lineSeparator());
            builder.append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom()));
        }
        return builder.toString();
    }
}
