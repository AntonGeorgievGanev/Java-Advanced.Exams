package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size; //volume
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish){
        if (capacity > this.fishInPool.size()){
            if (!this.fishInPool.contains(fish.getName())){
                this.fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name){
        for (Fish f : this.fishInPool){
            if (f.getName().equals(name)){
                this.fishInPool.remove(f);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name){
        for (Fish f : this.fishInPool){
            if (f.getName().equals(name)){
                return f;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size)).append(System.lineSeparator());
        for (Fish fish : this.fishInPool){
            builder.append(fish).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
