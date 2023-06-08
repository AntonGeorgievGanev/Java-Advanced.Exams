package Exams.E18August2021;

import java.util.*;

public class PastryShop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredientsStack::push);

        Map<String, Integer> pastry = new LinkedHashMap<>();
        pastry.put("Biscuit", 0);
        pastry.put("Cake", 0);
        pastry.put("Pie", 0);
        pastry.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){
            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();
            int mix = liquid + ingredient;

            if (mix == 100){
                pastry.put("Pie", pastry.get("Pie") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            }else if (mix == 75){
                pastry.put("Pastry", pastry.get("Pastry") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            }else if (mix == 50){
                pastry.put("Cake", pastry.get("Cake") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            }else if (mix == 25){
                pastry.put("Biscuit", pastry.get("Biscuit") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            }else{
                liquidsQueue.poll();
                int newValue = ingredientsStack.pop() + 3;
                ingredientsStack.push(newValue);
            }
        }
        List<String> liquidsLeft = new ArrayList<>();
        List<String> ingredientsLeft = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, Integer> entry : pastry.entrySet()) {
            if (entry.getValue() > 0){
                count++;
            }
        }

        if (count == 4){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else{
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            while (!liquidsQueue.isEmpty()){
                liquidsLeft.add(liquidsQueue.poll() + "");
            }

            System.out.printf("Liquids left: " + String.join(", ", liquidsLeft) + System.lineSeparator());
        }

        if (ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            while (!ingredientsStack.isEmpty()){
                ingredientsLeft.add(ingredientsStack.pop() + "");
            }

            System.out.printf("Ingredients left: " + String.join(", ", ingredientsLeft) + System.lineSeparator());
        }
        pastry.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
