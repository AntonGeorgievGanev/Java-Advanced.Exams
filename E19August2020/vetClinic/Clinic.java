package vetClinic;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (capacity > data.size()){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : data){
            if (pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data){
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet(){
        return data.stream().sorted(Collections.reverseOrder(Comparator.comparing(Pet::getAge))).collect(Collectors.toList()).get(0);
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append("The clinic has the following patients:").append(System.lineSeparator());
        data.stream().forEach(p -> {
            builder.append(String.format("%s %s", p.getName(), p.getOwner())).append(System.lineSeparator());
        });
        return builder.toString().trim();
    }

}
