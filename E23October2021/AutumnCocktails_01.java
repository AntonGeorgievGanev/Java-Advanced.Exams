package Exams.E23October2021;

import java.util.*;

public class AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Map<String, Integer> cocktails = new TreeMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredientsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(freshnessStack::push);

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredient = ingredientsQueue.peek();
            if (ingredient == 0) {
                ingredientsQueue.poll();
                continue;
            }
            int freshness = freshnessStack.peek();

            if (ingredient * freshness == 400) {
                cocktails.putIfAbsent("High Fashion", 0);
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (ingredient * freshness == 300) {
                cocktails.putIfAbsent("Apple Hinny", 0);
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (ingredient * freshness == 250) {
                cocktails.putIfAbsent("The Harvest", 0);
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else if (ingredient * freshness == 150) {
                cocktails.putIfAbsent("Pear Sour", 0);
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else {
                freshnessStack.pop();
                int newValue = ingredientsQueue.poll() + 5;
                ingredientsQueue.offer(newValue);
            }
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() > 0) {
                count++;
            }
        }

        if (count == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int ingredientsSum = 0;
        while (!ingredientsQueue.isEmpty()) {
            ingredientsSum += ingredientsQueue.poll();
        }

        while (!freshnessStack.isEmpty()) {
            ingredientsSum += freshnessStack.pop();
        }

        if (ingredientsSum > 0) {
            System.out.printf("Ingredients left: %d%n", ingredientsSum);
        }

        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
