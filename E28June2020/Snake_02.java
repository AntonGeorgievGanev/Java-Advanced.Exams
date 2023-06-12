package Exams.E28June2020;

import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int foodQuantity = 0;
        boolean isOut = false;

        for (int row = 0; row < size; row++) {
            String[] data = scanner.nextLine().split("");
            matrix[row] = data;
        }

        int currentRow = findStartPosition(matrix)[0];
        int currentCol = findStartPosition(matrix)[1];
        matrix[currentRow][currentCol] = ".";

        String direction = scanner.nextLine();
        while (foodQuantity < 10) {
            switch (direction) {
                case "up":
                    currentRow--;
                    if (currentRow < 0) {
                        isOut = true;
                    }
                    break;
                case "down":
                    currentRow++;
                    if (currentRow > size - 1) {
                        isOut = true;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (currentCol > size - 1) {
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


            if (matrix[currentRow][currentCol].equals("*")) {
                foodQuantity++;
                matrix[currentRow][currentCol] = ".";
            } else if (matrix[currentRow][currentCol].equals("B")) {
                matrix[currentRow][currentCol] = ".";
                currentRow = findExitBurrow(matrix)[0];
                currentCol = findExitBurrow(matrix)[1];
                matrix[currentRow][currentCol] = ".";
            } else if (matrix[currentRow][currentCol].equals("-")) {
                matrix[currentRow][currentCol] = ".";
            }

            if (foodQuantity >= 10) {
                break;
            }

            direction = scanner.nextLine();
        }

        if (isOut) {
            System.out.println("Game over!");
        }
        if (foodQuantity >= 10) {
            System.out.println("You won! You fed the snake.");
            matrix[currentRow][currentCol] = "S";
        }

        System.out.printf("Food eaten: %d%n", foodQuantity);
        printMatrix(matrix);
    }

    public static int[] findStartPosition(String[][] matrix) {
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("S")) {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }
        return new int[]{startRow, startCol};
    }

    public static int[] findExitBurrow(String[][] matrix) {
        int exitRow = -1;
        int exitCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("B")) {
                    exitRow = row;
                    exitCol = col;
                    break;
                }
            }
        }
        return new int[]{exitRow, exitCol};
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
