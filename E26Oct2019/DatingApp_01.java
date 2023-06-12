package Exams.E26Oct2019;

import java.util.*;

public class DatingApp_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesSTack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        int countMatches = 0;

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(malesSTack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(femalesQueue::offer);

        while (!malesSTack.isEmpty() && !femalesQueue.isEmpty()){
            int male = malesSTack.peek();
            int female = femalesQueue.peek();

            if (male <= 0 && female <= 0){
                malesSTack.pop();
                femalesQueue.poll();
                continue;
            }else if (male <= 0){
                malesSTack.pop();
                continue;
            }else if (female <= 0){
                femalesQueue.poll();
                continue;
            }

            if (male % 25 == 0){
                malesSTack.pop();
                if (!malesSTack.isEmpty()){
                    malesSTack.pop();
                }
                continue;
            }

            if (female % 25 == 0){
                femalesQueue.poll();
                if (!femalesQueue.isEmpty()){
                    femalesQueue.poll();
                }
                continue;
            }

            if (male == female){
                countMatches++;
                malesSTack.pop();
                femalesQueue.poll();
            }else {
                femalesQueue.poll();
                int newMale = malesSTack.pop() - 2;
                malesSTack.push(newMale);
            }
        }
        System.out.printf("Matches: %d%n", countMatches);

        if (!malesSTack.isEmpty()){
            List<String> malesLeft = new ArrayList<>();
            while (!malesSTack.isEmpty()){
                malesLeft.add(malesSTack.pop() + "");
            }
            System.out.println("Males left: " + String.join(", ", malesLeft));
        }else{
            System.out.println("Males left: none");
        }

        if (!femalesQueue.isEmpty()){
            List<String> femalesLeft = new ArrayList<>();
            while (!femalesQueue.isEmpty()){
                femalesLeft.add(femalesQueue.poll() + "");
            }
            System.out.println("Females left: " + String.join(", ", femalesLeft));
        }else{
            System.out.println("Females left: none");
        }
    }
}
