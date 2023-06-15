package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth){
        if (capacity > data.size()){
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color){
        for (Cloth cloth : data){
            if (cloth.getColor().equals(color)){
                data.remove(cloth);
                return true;
            }
        }
        return false;
    }

    public Cloth getSmallestCloth(){
        return data.stream().sorted(Comparator.comparing(Cloth::getSize)).collect(Collectors.toList()).get(0);
    }

    public Cloth getCloth(String color){
        for (Cloth cloth : data){
            if (cloth.getColor().equals(color)){
                return cloth;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s magazine contains:", type)).append(System.lineSeparator());
        data.forEach(c -> builder.append(c).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
