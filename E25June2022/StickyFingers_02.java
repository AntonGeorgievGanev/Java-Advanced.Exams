package Exams.E25June2022;

import java.util.Arrays;
import java.util.Scanner;

public class StickyFingers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");
        String[][] matrix = new String[size][size];
        for (int row = 0; row < size; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = data[col];
            }
        }
        int currentRow = findInitialPosition(matrix)[0];
        int currentCol = findInitialPosition(matrix)[1];
        matrix[currentRow][currentCol] = "+";
        int moneyRobbed = 0;
        boolean jail = false;

        for (int i = 0; i < directions.length; i++) {
            String direction = directions[i];
            switch (direction) {
                case "up":
                    if (currentRow - 1 >= 0) {
                        currentRow--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (currentRow + 1 < size) {
                        currentRow++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (currentCol + 1 < size) {
                        currentCol++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (currentCol - 1 >= 0) {
                        currentCol--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }
            if (matrix[currentRow][currentCol].equals("P")) {
                matrix[currentRow][currentCol] = "#";
                jail = true;
                break;
            } else if (matrix[currentRow][currentCol].equals("$")) {
                System.out.printf("You successfully stole %d$.%n", currentRow * currentCol);
                moneyRobbed = moneyRobbed + (currentRow * currentCol);
                matrix[currentRow][currentCol] = "+";
            }

        }
        if (jail) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", moneyRobbed);
        } else {
            matrix[currentRow][currentCol] = "D";
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", moneyRobbed);
        }
        printMatrix(matrix);
    }

    public static int[] findInitialPosition(String[][] matrix) {
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("D")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }
        return new int[]{startRow, startCol};
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
