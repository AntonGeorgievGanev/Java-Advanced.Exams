package Exams.E26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(taskStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(threadsQueue::offer);
        int taskToKill = Integer.parseInt(scanner.nextLine());
        boolean isKilled = false;
        int threadKiller = 0;

        while (!isKilled){
            int task = taskStack.peek();
            int thread = threadsQueue.peek();

            if (task == taskToKill){
                isKilled = true;
                threadKiller = thread;
                break;
            }

            if (thread >= task){
                taskStack.pop();
                threadsQueue.poll();
            }else {
                threadsQueue.poll();
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threadKiller, taskToKill);
        while (!threadsQueue.isEmpty()){
            System.out.print(threadsQueue.poll() + " ");
        }
    }
}
