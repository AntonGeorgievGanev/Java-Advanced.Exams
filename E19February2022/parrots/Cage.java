package Exams.E19February2022.parrots;

import parrots.Parrot;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot){
        if (capacity > this.data.size()){
            data.add(parrot);
        }
    }

    public boolean remove(String name){
        for (Parrot parrot : data){
            if (parrot.getName().equals(name)){
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name){
        Parrot soldParrot = null;
        for (Parrot parrot : data){
            if (parrot.getName().equals(name)){
                parrot.setAvailable(false);
                soldParrot = parrot;
            }
        }
        return soldParrot;
    }

    public int count(){
        return this.data.size();
    }

    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> soldParrots = new ArrayList<>();
        for (Parrot parrot : data){
            if (parrot.getSpecies().equals(species)){
                parrot.setAvailable(false);
                soldParrots.add(parrot);
            }
        }
        return soldParrots;
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s:", name)).append(System.lineSeparator());
        for (Parrot parrot : data){
            if (parrot.isAvailable()){
                builder.append(parrot);
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}
