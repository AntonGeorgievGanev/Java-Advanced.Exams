package Exams.E18February2023;

import java.util.*;

public class ApocalypsePreparation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> medicamentStack = new ArrayDeque<>();
        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(textilesQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(medicamentStack::push);

        Map<String, Integer> createdItems = new TreeMap<>();

        while (!textilesQueue.isEmpty() && !medicamentStack.isEmpty()) {
            int textilesItem = textilesQueue.peek();
            int medItem = medicamentStack.peek();
            int sumOfItems = textilesItem + medItem;

            if (sumOfItems == 100) {
                createdItems.putIfAbsent("MedKit", 0);
                createdItems.put("MedKit", createdItems.get("MedKit") + 1);
                textilesQueue.poll();
                medicamentStack.pop();
            } else if (sumOfItems == 40) {
                createdItems.putIfAbsent("Bandage", 0);
                createdItems.put("Bandage", createdItems.get("Bandage") + 1);
                textilesQueue.poll();
                medicamentStack.pop();
            } else if (sumOfItems == 30) {
                createdItems.putIfAbsent("Patch", 0);
                createdItems.put("Patch", createdItems.get("Patch") + 1);
                textilesQueue.poll();
                medicamentStack.pop();

            } else if (sumOfItems > 100) {
                createdItems.putIfAbsent("MedKit", 0);
                createdItems.put("MedKit", createdItems.get("MedKit") + 1);
                textilesQueue.poll();
                medicamentStack.pop();
                int newValue = (sumOfItems - 100) + medicamentStack.pop();
                medicamentStack.push(newValue);
            } else {
                textilesQueue.poll();
                int newMedicament = medicamentStack.pop() + 10;
                medicamentStack.push(newMedicament);
            }
        }

        if (textilesQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");

        } else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");

        } else {
            System.out.println("Textiles are empty.");
        }

        if (!createdItems.isEmpty()) {
            createdItems.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e -> {
                System.out.printf("%s - %d%n", e.getKey(), e.getValue());
            });
        }

        if (!textilesQueue.isEmpty()){
            List<String> textilesLeft = new ArrayList<>();
            while (!textilesQueue.isEmpty()) {
                textilesLeft.add(textilesQueue.poll() + "");
            }
            System.out.println("Textiles left: " + String.join(", ", textilesLeft));
        }else if (!medicamentStack.isEmpty()){
            List<String> medicamentsLeft = new ArrayList<>();
            while (!medicamentStack.isEmpty()) {
                medicamentsLeft.add(medicamentStack.pop() + "");
            }
            System.out.println("Medicaments left: " + String.join(", ", medicamentsLeft));
        }
    }
}
