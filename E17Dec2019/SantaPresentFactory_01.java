package Exams.E17Dec2019;

import java.util.*;

public class SantaPresentFactory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materialsStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magicQueue::offer);

        Map<String, Integer> presents = new TreeMap<>();

        while (!materialsStack.isEmpty() && !magicQueue.isEmpty()) {
            int material = materialsStack.peek();
            int magic = magicQueue.peek();
            int sum = material * magic;

            if (material == 0 && magic == 0) {
                materialsStack.pop();
                magicQueue.poll();
                continue;
            }else if (magic == 0) {
                magicQueue.poll();
                continue;
            }else if (material == 0){
                materialsStack.pop();
                continue;
            }

            if (sum < 0) {
                int newMaterial = material + magic;
                materialsStack.pop();
                magicQueue.poll();
                materialsStack.push(newMaterial);
            } else if (sum == 400) {
                presents.putIfAbsent("Bicycle", 0);
                presents.put("Bicycle", presents.get("Bicycle") + 1);
                materialsStack.pop();
                magicQueue.poll();
            } else if (sum == 300) {
                presents.putIfAbsent("Teddy bear", 0);
                presents.put("Teddy bear", presents.get("Teddy bear") + 1);
                materialsStack.pop();
                magicQueue.poll();
            } else if (sum == 250) {
                presents.putIfAbsent("Wooden train", 0);
                presents.put("Wooden train", presents.get("Wooden train") + 1);
                materialsStack.pop();
                magicQueue.poll();
            } else if (sum == 150) {
                presents.putIfAbsent("Doll", 0);
                presents.put("Doll", presents.get("Doll") + 1);
                materialsStack.pop();
                magicQueue.poll();
            } else {
                magicQueue.poll();
                int newMaterial = materialsStack.pop() + 15;
                materialsStack.push(newMaterial);
            }
        }

        List<String> pairDollTrain = new ArrayList<>();
        List<String> pairBearBicycle = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            if (entry.getKey().equals("Doll") && entry.getValue() > 0) {
                pairDollTrain.add("Doll");
            } else if (entry.getKey().equals("Wooden train") && entry.getValue() > 0) {
                pairDollTrain.add("Wooden train");
            } else if (entry.getKey().equals("Teddy bear") && entry.getValue() > 0) {
                pairBearBicycle.add("Teddy bear");
            } else if (entry.getKey().equals("Bicycle") && entry.getValue() > 0) {
                pairBearBicycle.add("Bicycle");
            }
        }

        if (pairBearBicycle.size() == 2 || pairDollTrain.size() == 2){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else{
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()){
            List<String> materialsLeft = new ArrayList<>();
            while (!materialsStack.isEmpty()){
                materialsLeft.add(materialsStack.pop() + "");
            }
            System.out.println("Materials left: " + String.join(", ", materialsLeft));
        }

        if (!magicQueue.isEmpty()){
            List<String> magicLeft = new ArrayList<>();
            while (!magicQueue.isEmpty()){
                magicLeft.add(magicQueue.poll() + "");
            }
            System.out.println("Magic left: " + String.join(", ", magicLeft));
        }

        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            if (entry.getValue() > 0){
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
