package Exams.E28June2020;

import com.sun.jdi.IntegerType;

import java.util.*;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingSTack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombEffectsQueue::offer);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombCasingSTack::push);
        Map<String, Integer> bombMade = new TreeMap<>();
        bombMade.put("Smoke Decoy Bombs", 0);
        bombMade.put("Cherry Bombs", 0);
        bombMade.put("Datura Bombs", 0);
        boolean haveBombs = false;

        while (!bombEffectsQueue.isEmpty() && !bombCasingSTack.isEmpty()) {
            int effect = bombEffectsQueue.peek();
            int casing = bombCasingSTack.peek();
            int bombMix = effect + casing;
            int count = 0;

            if (bombMix == 120) {
                bombMade.put("Smoke Decoy Bombs", bombMade.get("Smoke Decoy Bombs") + 1);
                bombEffectsQueue.poll();
                bombCasingSTack.pop();
            } else if (bombMix == 60) {
                bombMade.put("Cherry Bombs", bombMade.get("Cherry Bombs") + 1);
                bombEffectsQueue.poll();
                bombCasingSTack.pop();
            } else if (bombMix == 40) {
                bombMade.put("Datura Bombs", bombMade.get("Datura Bombs") + 1);
                bombEffectsQueue.poll();
                bombCasingSTack.pop();
            } else {
                int newCasing = bombCasingSTack.pop() - 5;
                bombCasingSTack.push(newCasing);
            }
            for (Map.Entry<String, Integer> bomb : bombMade.entrySet()) {
                if (bomb.getValue() >= 3) {
                    count++;
                }
            }
            if (count >= 3) {
                haveBombs = true;
                break;
            }
        }

        if (haveBombs) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            List<String> effectsLeft = new ArrayList<>();
            while (!bombEffectsQueue.isEmpty()) {
                effectsLeft.add(bombEffectsQueue.poll() + "");
            }

            System.out.println("Bomb Effects: " + String.join(", ", effectsLeft));
        }

        if (bombCasingSTack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            List<String> casingLeft = new ArrayList<>();
            while (!bombCasingSTack.isEmpty()) {
                casingLeft.add(bombCasingSTack.pop() + "");
            }
            System.out.println("Bomb Casings: " + String.join(", ", casingLeft));
        }

        bombMade.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
