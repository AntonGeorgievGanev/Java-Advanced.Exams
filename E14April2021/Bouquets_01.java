package Exams.E14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        int countOfBuckets = 0;
        int leftSum = 0;

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tulipsStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(daffodilsQueue::offer);

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()){
            int tulips = tulipsStack.peek();
            int daffodils = daffodilsQueue.peek();
            int flowerMix = tulips + daffodils;

            if (flowerMix == 15){
                countOfBuckets++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }else if (flowerMix < 15){
                leftSum += flowerMix;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }else if (flowerMix > 15){
                while (flowerMix != 15){
                    flowerMix -= 2;
                    if (flowerMix == 15){
                        countOfBuckets++;
                        tulipsStack.pop();
                        daffodilsQueue.poll();
                        break;
                    }else if (flowerMix < 15){
                        leftSum += flowerMix;
                        tulipsStack.pop();
                        daffodilsQueue.poll();
                        break;
                    }
                }
            }
        }
        if (leftSum > 15){
            int addBouquets = leftSum / 15;
            countOfBuckets += addBouquets;
        }
        if (countOfBuckets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", countOfBuckets);
        }else{
            System.out.printf("You failed... You need more %d bouquets.", 5 - countOfBuckets);
        }
    }
}
