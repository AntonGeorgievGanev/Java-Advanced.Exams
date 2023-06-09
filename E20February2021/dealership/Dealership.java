package dealership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (capacity > data.size()){
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        for (Car car : data){
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        if (data.isEmpty()){
            return null;
        }else {
            return data.stream().sorted(Collections.reverseOrder(Comparator.comparing(Car::getYear))).collect(Collectors.toList()).get(0);
        }
    }

    public Car getCar(String manufacturer, String model){
        for (Car car : data){
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:", name)).append(System.lineSeparator());
        data.forEach(c -> builder.append(c).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
