package Exams.E26June2021.groomingSalon;

import groomingSalon.Pet;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<groomingSalon.Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(groomingSalon.Pet pet){
        if (capacity > data.size()){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        for (groomingSalon.Pet pet : data){
            if (pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public groomingSalon.Pet getPet(String name, String owner){
        for (groomingSalon.Pet pet : data){
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data){
            builder.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
