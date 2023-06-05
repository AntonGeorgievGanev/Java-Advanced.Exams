package Exams.E22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> mgStack = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(mgStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(energyDrinksQueue::offer);

        int currentCaffeine = 0;

        while (!mgStack.isEmpty() && !energyDrinksQueue.isEmpty()){
            int caffeineToAdd = mgStack.peek() * energyDrinksQueue.peek();
            if (currentCaffeine + caffeineToAdd <= 300){
                currentCaffeine += caffeineToAdd;
                mgStack.pop();
                energyDrinksQueue.poll();
            }else{
                mgStack.pop();
                int drinkToAddAtEnd = energyDrinksQueue.poll();
                energyDrinksQueue.offer(drinkToAddAtEnd);
                currentCaffeine -= 30;
                if (currentCaffeine <= 0){
                    currentCaffeine = 0;
                }
            }
        }
        if (!energyDrinksQueue.isEmpty()){
            List<String> drinks =  energyDrinksQueue.stream().map(Object::toString).collect(Collectors.toList());
            System.out.println("Drinks left: " + String.join(", ", drinks));
        }else{
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", currentCaffeine);
    }
}

