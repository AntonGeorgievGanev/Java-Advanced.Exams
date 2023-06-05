package Exams.E25June2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ItsChocolateTime_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).forEach(milkQueue::offer);
        Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).forEach(cacaoStack::push);

        Map<Double, String> chocolateMap = new LinkedHashMap<>();
        chocolateMap.put(30.0, "Milk Chocolate");
        chocolateMap.put(50.0, "Dark Chocolate");
        chocolateMap.put(100.0, "Baking Chocolate");

        Map<String, Integer> createdChocolate = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milkCacaoMix = (cacaoStack.peek() / (milkQueue.peek() + cacaoStack.peek())) * 100;

            if (chocolateMap.containsKey(milkCacaoMix)) {
                String typeOfChocolate = chocolateMap.get(milkCacaoMix);
                createdChocolate.putIfAbsent(typeOfChocolate, 0);
                createdChocolate.put(typeOfChocolate, createdChocolate.get(typeOfChocolate) + 1);
                milkQueue.poll();
                cacaoStack.pop();
            }else{
                cacaoStack.pop();
                double newMilkValue = milkQueue.poll() + 10;
                milkQueue.offer(newMilkValue);
            }
        }
        if (createdChocolate.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        if (!createdChocolate.isEmpty()) {
            createdChocolate.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
        }
    }
}
