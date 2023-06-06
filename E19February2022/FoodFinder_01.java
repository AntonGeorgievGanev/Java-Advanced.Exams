package Exams.E19February2022;

import java.util.*;

public class FoodFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowelsQueue.offer(e.charAt(0)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonantsStack.push(e.charAt(0)));

        Map<String, StringBuilder> foodFinder = new LinkedHashMap<>();
        foodFinder.put("pear", new StringBuilder("pear"));
        foodFinder.put("flour", new StringBuilder("flour"));
        foodFinder.put("pork", new StringBuilder("pork"));
        foodFinder.put("olive", new StringBuilder("olive"));

        while (!consonantsStack.isEmpty()) {
            char vowel = vowelsQueue.poll();
            char consonant = consonantsStack.pop();
            for (Map.Entry<String, StringBuilder> entry : foodFinder.entrySet()) {
                for (int i = 0; i < entry.getKey().length(); i++) {
                    if (entry.getValue().charAt(i) == vowel) {
                        entry.getValue().replace(i, i + 1, "*");
                    }
                }

                for (int i = 0; i < entry.getKey().length(); i++) {
                    if (entry.getValue().charAt(i) == consonant) {
                        entry.getValue().replace(i, i + 1, "*");
                    }
                }
            }

            vowelsQueue.offer(vowel);
        }

        List<String> foundFoods = new ArrayList<>();
        for (Map.Entry<String, StringBuilder> entry : foodFinder.entrySet()) {
            boolean found = true;
            for (int i = 0; i < entry.getValue().length(); i++) {
                if (entry.getValue().toString().charAt(i) != '*') {
                    found = false;
                    break;
                }
            }
            if (found) {
                foundFoods.add(entry.getKey());
            }
        }

        System.out.printf("Words found: %d%n", foundFoods.size());
        foundFoods.forEach(System.out::println);
    }
}
