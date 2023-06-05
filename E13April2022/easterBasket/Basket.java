package easterBasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg){
        if (this.data.size() < capacity){
            data.add(egg);
        }
    }

    public boolean removeEgg(String color){
        for (Egg egg : data){
            if (egg.getColor().equals(color)){
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg(){
        return data.stream().sorted(Collections.reverseOrder(Comparator.comparing(Egg::getStrength))).collect(Collectors.toList()).get(0);
    }

    public Egg getEgg(String color){
        Egg egg1 = null;
        for (Egg egg : data){
            if (egg.getColor().equals(color)){
                egg1 = egg;
                break;
            }
        }
        return egg1;
    }

    public int getCount(){
        return data.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s basket contains:", material));
        for (Egg egg : data){
            builder.append(System.lineSeparator());
            builder.append(egg);
        }

        return builder.toString();
    }
}
