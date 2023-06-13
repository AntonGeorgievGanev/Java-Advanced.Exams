package Exams.E22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstBoxQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondBoxStack::push);

        int totalSum = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int firstItem = firstBoxQueue.peek();
            int secondItem = secondBoxStack.peek();
            int sumItems = firstItem + secondItem;

            if (sumItems % 2 == 0){
                totalSum += sumItems;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            }else{
                firstBoxQueue.offer(secondBoxStack.pop());
            }
        }

        if (firstBoxQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }

        if (totalSum >= 100){
            System.out.printf("Your loot was epic! Value: %d%n", totalSum);
        }else{
            System.out.printf("Your loot was poor... Value: %d%n", totalSum);
        }
    }
}
