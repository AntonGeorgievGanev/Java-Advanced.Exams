package Exams.E26June2021;

import java.util.Scanner;

public class Python_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        String[][] matrix = new String[n][n];
        int snakeLength = 1;

        for (int row = 0; row < n; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = data[col];
            }
        }

        int currentRow = findStartPosition(matrix)[0];
        int currentCol = findStartPosition(matrix)[1];
        matrix[currentRow][currentCol] = "*";
        int foodOnTheField = countFood(matrix);

        for (int i = 0; i < commands.length; i++) {
            String direction = commands[i];
            switch (direction) {
                case "up":
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    currentRow++;
                    if (currentRow > matrix.length - 1) {
                        currentRow = 0;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (currentCol > matrix.length - 1) {
                        currentCol = 0;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol = matrix.length - 1;
                    }
                    break;
            }
            if (matrix[currentRow][currentCol].equals("f")) {
                matrix[currentRow][currentCol] = "*";
                snakeLength++;
                foodOnTheField--;
                if (foodOnTheField == 0) {
                    System.out.printf("You win! Final python length is %d", snakeLength);
                    return;
                }

            } else if (matrix[currentRow][currentCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }
        System.out.printf("You lose! There is still %d food to be eaten.", foodOnTheField);
    }

    public static int[] findStartPosition(String[][] matrix) {
        int snakeRow = -1;
        int snakeCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("s")) {
                    snakeRow = row;
                    snakeCol = col;
                    break;
                }
            }
        }
        return new int[]{snakeRow, snakeCol};
    }

    public static int countFood(String[][] matrix) {
        int countFood = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("f")) {
                    countFood++;
                }
            }
        }
        return countFood;
    }
}