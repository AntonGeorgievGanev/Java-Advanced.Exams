package Exams.E19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        int sumAdd = 0;
        int countWreaths = 0;

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(liliesStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(rosesQueue::offer);

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()){
            int lily = liliesStack.peek();
            int rose = rosesQueue.peek();
            int flowerMix = lily + rose;

            if (flowerMix == 15){
                countWreaths++;
                liliesStack.pop();
                rosesQueue.poll();
            }else if (flowerMix > 15){
                while (flowerMix != 15){
                    flowerMix -= 2;
                    if (flowerMix == 15){
                        countWreaths++;
                        liliesStack.pop();
                        rosesQueue.poll();
                        break;
                    }else if (flowerMix < 15){
                        sumAdd += flowerMix;
                        liliesStack.pop();
                        rosesQueue.poll();
                        break;
                    }
                }
            }else if (flowerMix < 15){
                sumAdd += flowerMix;
                liliesStack.pop();
                rosesQueue.poll();
            }
        }
        if (sumAdd > 15){
            countWreaths += sumAdd / 15;
        }

        if (countWreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreaths);
        }
    }
}
