package Exams.E15December2021;

import java.util.*;

public class Meeting_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(maleStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(femaleQueue::offer);
        int countMatches = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int male = maleStack.peek();
            int female = femaleQueue.peek();

            if (male <= 0){
                maleStack.pop();
                continue;
            }

            if (female <= 0){
                femaleQueue.poll();
                continue;
            }

            if (male % 25 == 0){
                maleStack.pop();
                if (maleStack.isEmpty()){
                    break;
                }else {
                    maleStack.pop();
                }
                continue;
            }

            if (female % 25 == 0){
                femaleQueue.poll();
                if (femaleQueue.isEmpty()){
                    break;
                }else {
                    femaleQueue.poll();
                }
                continue;
            }

            if (maleStack.peek() == femaleQueue.peek()){
                countMatches++;
                maleStack.pop();
                femaleQueue.poll();
            }else{
                femaleQueue.poll();
                int newValue = maleStack.pop() - 2;
                maleStack.push(newValue);
            }
        }
        System.out.printf("Matches: %d%n", countMatches);
        if (maleStack.isEmpty()){
            System.out.println("Males left: none");
        }else{
            List<String> malesLeft = new ArrayList<>();
            while (!maleStack.isEmpty()){
                malesLeft.add(maleStack.pop() + "");
            }
            System.out.println("Males left: " + String.join(", ", malesLeft));
        }

        if (femaleQueue.isEmpty()){
            System.out.println("Females left: none");
        }else{
            List<String> femalesLeft = new ArrayList<>();
            while (!femaleQueue.isEmpty()){
                femalesLeft.add(femaleQueue.poll() + "");
            }
            System.out.println("Females left: " + String.join(", ", femalesLeft));
        }
    }
}
