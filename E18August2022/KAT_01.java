package Exams.E18August2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class KAT_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(licensePlatesQueue::offer);
        Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(carsStack::push);
        int days = 0;
        int registeredCars = 0;

        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()){

            int licenseAvailable = licensePlatesQueue.poll() / 2;
            int carsWaitingForLicense = carsStack.pop();
            if (licenseAvailable >= carsWaitingForLicense){
                registeredCars += carsWaitingForLicense;
                if (licenseAvailable - carsWaitingForLicense > 0) {
                    int leftLicensePlates = licenseAvailable - carsWaitingForLicense;
                    licensePlatesQueue.offer(leftLicensePlates * 2);
                }
            }else {
                int carLeft = carsWaitingForLicense - licenseAvailable;
                registeredCars += licenseAvailable;
                carsStack.addLast(carLeft);
            }
            days++;
        }
        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);
        if (licensePlatesQueue.isEmpty() && carsStack.isEmpty()){
            System.out.println("Good job! There is no queue in front of the KAT!");
        }else if (licensePlatesQueue.isEmpty()){
            int carsWithoutLicense = 0;
            while (!carsStack.isEmpty()){
                carsWithoutLicense += carsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!%n", carsWithoutLicense);
        }else {
            int licenseLeft = 0;
            while (!licensePlatesQueue.isEmpty()){
                licenseLeft += licensePlatesQueue.poll();
            }
            System.out.printf("%d license plates remain!%n", licenseLeft);
        }
    }
}
