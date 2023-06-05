package Exams.E14December2022;

import java.util.*;

public class ClimbThePeaks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> foodStack = new ArrayDeque<>();
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(foodStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(staminaQueue::offer);
        List<String> conqueredPeeks = new ArrayList<>();
        List<String> peeks = new ArrayList<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));

        Map<String, Integer> peeksToClimb = new LinkedHashMap<>();
        peeksToClimb.put("Vihren", 80);
        peeksToClimb.put("Kutelo", 90);
        peeksToClimb.put("Banski Suhodol", 100);
        peeksToClimb.put("Polezhan", 60);
        peeksToClimb.put("Kamenitza", 70);

        for (int day = 1; day <= 7 ; day++) {
            int powerToClimb = foodStack.pop() + staminaQueue.poll();
            String currentPeek = peeks.get(0);
            int peekDifficulty = peeksToClimb.get(currentPeek);
            if (powerToClimb >= peekDifficulty){
                peeks.remove(0);
                conqueredPeeks.add(currentPeek);
            }
            if (peeks.isEmpty()){
                break;
            }
        }
        if (peeks.isEmpty()){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }else{
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeeks.isEmpty()){
            System.out.println("Conquered peaks:");
            conqueredPeeks.forEach(System.out::println);
        }
    }
}
