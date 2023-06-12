package parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (capacity > data.size()){
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
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
        }else{
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
        builder.append(String.format("The cars are parked in %s:", type)).append(System.lineSeparator());
        data.forEach(c -> builder.append(c).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
