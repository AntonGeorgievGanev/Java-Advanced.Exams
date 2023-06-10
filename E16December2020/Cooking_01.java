package Exams.E16December2020;

import java.util.*;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredientsStack::push);
        Map<String, Integer> createdFood = new TreeMap<>();
        createdFood.putIfAbsent("Bread", 0);
        createdFood.putIfAbsent("Pastry", 0);
        createdFood.putIfAbsent("Cake", 0);
        createdFood.putIfAbsent("Fruit Pie", 0);


        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();
            int product = liquid + ingredient;

            if (product == 25) {
                createdFood.put("Bread", createdFood.get("Bread") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (product == 50) {
                createdFood.put("Cake", createdFood.get("Cake") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (product == 75) {
                createdFood.put("Pastry", createdFood.get("Pastry") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (product == 100) {
                createdFood.put("Fruit Pie", createdFood.get("Fruit Pie") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                int newIngredient = ingredientsStack.pop() + 3;
                ingredientsStack.push(newIngredient);
            }
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : createdFood.entrySet()) {
            if (entry.getValue() > 0) {
                count++;
            }
        }

        if (count >= 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> liquidsLeft = new ArrayList<>();
            while (!liquidsQueue.isEmpty()) {
                liquidsLeft.add(liquidsQueue.poll() + "");
            }
            System.out.println("Liquids left: " + String.join(", ", liquidsLeft));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> ingredientsLeft = new ArrayList<>();
            while (!ingredientsStack.isEmpty()) {
                ingredientsLeft.add(ingredientsStack.pop() + "");
            }
            System.out.println("Ingredients left: " + String.join(", ", ingredientsLeft));
        }
        createdFood.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
