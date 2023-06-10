package Exams.E19August2020;

import java.util.Scanner;

public class Bee_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        int countFlowers = 0;
        boolean isOut = false;

        for (int row = 0; row < n; row++) {
            String[] data = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = data[col];
            }
        }
        int currentRow = findTheBee(matrix)[0];
        int currentCol = findTheBee(matrix)[1];
        matrix[currentRow][currentCol] = ".";

        String direction = scanner.nextLine();

        while (!direction.equals("End")) {
            switch (direction) {
                case "up":
                    currentRow--;
                    if (currentRow < 0) {
                        isOut = true;
                    }
                    break;
                case "down":
                    currentRow++;
                    if (currentRow > n - 1) {
                        isOut = true;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (currentCol > n - 1) {
                        isOut = true;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (currentCol < 0) {
                        isOut = true;
                    }
                    break;
            }
            if (isOut) {
                break;
            }
            if (matrix[currentRow][currentCol].equals("f")) {
                countFlowers++;
                matrix[currentRow][currentCol] = ".";
            } else if (matrix[currentRow][currentCol].equals("O")) {
                matrix[currentRow][currentCol] = ".";
                continue;
            }
            direction = scanner.nextLine();
        }

        if (isOut) {
            System.out.println("The bee got lost!");
            if (countFlowers < 5) {
                System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - countFlowers);

            } else {
                System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", countFlowers);
            }
        } else {
            matrix[currentRow][currentCol] = "B";
            if (countFlowers < 5) {
                System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - countFlowers);

            } else {
                System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", countFlowers);
            }
        }
        printMatrix(matrix);
    }

    public static int[] findTheBee(String[][] matrix) {
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("B")) {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }
        return new int[]{startRow, startCol};
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
