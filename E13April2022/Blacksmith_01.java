package Exams.E13April2022;

import java.util.*;

public class Blacksmith_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(steelQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(carbonStack::push);
        Map<String, Integer> createdItems = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()){
            int sumMix = steelQueue.peek() + carbonStack.peek();

            if (sumMix == 110){
                createdItems.putIfAbsent("Sabre", 0);
                createdItems.put("Sabre", createdItems.get("Sabre") + 1);
                steelQueue.poll();
                carbonStack.pop();
            }else if (sumMix == 90){
                createdItems.putIfAbsent("Katana", 0);
                createdItems.put("Katana", createdItems.get("Katana") + 1);
                steelQueue.poll();
                carbonStack.pop();
            }else if (sumMix == 80){
                createdItems.putIfAbsent("Shamshir", 0);
                createdItems.put("Shamshir", createdItems.get("Shamshir") + 1);
                steelQueue.poll();
                carbonStack.pop();
            }else if (sumMix == 70){
                createdItems.putIfAbsent("Gladius", 0);
                createdItems.put("Gladius", createdItems.get("Gladius") + 1);
                steelQueue.poll();
                carbonStack.pop();
            }else{
                steelQueue.poll();
                int newValue = carbonStack.pop() + 5;
                carbonStack.push(newValue);
            }
        }
        if (createdItems.isEmpty()){
            System.out.println("You did not have enough resources to forge a sword.");
        }else{
            int totalSwords = 0;
            for (Map.Entry<String, Integer> entry : createdItems.entrySet()) {
                totalSwords += entry.getValue();
            }
            System.out.printf("You have forged %d swords.%n", totalSwords);
        }

        if (steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        }else{
            List<String> steelLeft = new ArrayList<>();
            while (!steelQueue.isEmpty()){
                steelLeft.add(steelQueue.poll() + "");
            }
            System.out.printf("Steel left: " + String.join(", ", steelLeft));
            System.out.println();
        }

        if (carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        }else{
            List<String> carbonLeft = new ArrayList<>();
            while (!carbonStack.isEmpty()){
                carbonLeft.add(carbonStack.pop() + "");
            }
            System.out.printf("Carbon left: " + String.join(", ", carbonLeft));
            System.out.println();
        }

        if (!createdItems.isEmpty()){
            createdItems.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        }
    }
}
