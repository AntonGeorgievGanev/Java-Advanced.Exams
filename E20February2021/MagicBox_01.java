package Exams.E20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstBoxQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondBoxStack::push);
        int qualitySum = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int firstNum = firstBoxQueue.peek();
            int secondNum = secondBoxStack.peek();
            int sum = firstNum + secondNum;

            if (sum % 2 == 0){
                qualitySum += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            }else{
                int removed = secondBoxStack.pop();
                firstBoxQueue.offer(removed);
            }
        }
        if (firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }else {
            System.out.println("Second magic box is empty.");
        }

        if (qualitySum >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d%n", qualitySum);
        }else{
            System.out.printf("Poor prey... Value: %d%n", qualitySum);
        }
    }
}
