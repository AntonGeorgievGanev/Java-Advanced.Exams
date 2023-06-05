package shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal){
        if (this.data.size() < capacity){
            this.data.add(animal);
        }
    }

    public boolean remove(String name){
        for (Animal animal : this.data){
            if (animal.getName().equals(name)){
                this.data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker){
        for (Animal animal : this.data){
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)){
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal(){
        return this.data.stream().sorted(Collections.reverseOrder(Comparator.comparing(Animal::getAge))).collect(Collectors.toList()).get(0);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        //The shelter has the following animals:
        //{name} {caretaker}
        //{name} {caretaker}
        builder.append("The shelter has the following animals:");
        for (Animal animal : data){
            builder.append(System.lineSeparator());
            builder.append(String.format(animal.getName() + " " + animal.getCaretaker()));
        }
        return builder.toString();
    }
}
