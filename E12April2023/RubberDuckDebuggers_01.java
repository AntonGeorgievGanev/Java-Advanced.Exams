package Exams.E12April2023;

import java.util.*;

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> timesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(timesQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(tasksStack::push);

        Map<String, Integer> rubberDucks = new LinkedHashMap<>();
        rubberDucks.put("Darth Vader Ducky", 0);
        rubberDucks.put("Thor Ducky", 0);
        rubberDucks.put("Big Blue Rubber Ducky", 0);
        rubberDucks.put("Small Yellow Rubber Ducky", 0);

        while (!timesQueue.isEmpty() && !tasksStack.isEmpty()) {
            int time = timesQueue.peek();
            int task = tasksStack.peek();
            int product = time * task;

            if (product >= 0 && product <= 60) {
                rubberDucks.put("Darth Vader Ducky", rubberDucks.get("Darth Vader Ducky") + 1);
                timesQueue.poll();
                tasksStack.pop();
            } else if (product >= 61 && product <= 120) {
                rubberDucks.put("Thor Ducky", rubberDucks.get("Thor Ducky") + 1);
                timesQueue.poll();
                tasksStack.pop();
            } else if (product >= 121 && product <= 180) {
                rubberDucks.put("Big Blue Rubber Ducky", rubberDucks.get("Big Blue Rubber Ducky") + 1);
                timesQueue.poll();
                tasksStack.pop();
            } else if (product >= 181 && product <= 240) {
                rubberDucks.put("Small Yellow Rubber Ducky", rubberDucks.get("Small Yellow Rubber Ducky") + 1);
                timesQueue.poll();
                tasksStack.pop();
            } else {
                int newTask = tasksStack.pop() - 2;
                tasksStack.push(newTask);
                if (!timesQueue.isEmpty()) {
                    int timeRemoved = timesQueue.poll();
                    timesQueue.offer(timeRemoved);
                    continue;
                }

            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        rubberDucks.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
