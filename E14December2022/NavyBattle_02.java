package Exams.E14December2022;

import java.util.Scanner;

public class NavyBattle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int countMines = 0;
        int countCruisers = 0;
        boolean isDestroyed = false;
        boolean win = false;

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = currentRow[col];
            }
        }
        int currentRow = findSubmarinePosition(matrix)[0];
        int currentCol = findSubmarinePosition(matrix)[1];
        matrix[currentRow][currentCol] = "-";

        String direction = scanner.nextLine();
        while (countCruisers < 3 || countMines < 3) {
            switch (direction) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "left":
                    currentCol--;
                    break;
            }
            if (matrix[currentRow][currentCol].equals("*")) {
                countMines++;
                matrix[currentRow][currentCol] = "-";
                if (countMines == 3) {
                    isDestroyed = true;
                    matrix[currentRow][currentCol] = "S";
                    break;
                }
            } else if (matrix[currentRow][currentCol].equals("C")) {
                countCruisers++;
                matrix[currentRow][currentCol] = "-";
                if (countCruisers == 3) {
                    matrix[currentRow][currentCol] = "S";
                    win = true;
                    break;
                }
            } else {
                matrix[currentRow][currentCol] = "-";
            }
            direction = scanner.nextLine();
        }
        if (win) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } else if (isDestroyed) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", currentRow, currentCol);
        }

        printMatrix(matrix);
    }

    public static int[] findSubmarinePosition(String[][] matrix) {
        int startRow = -1;
        int starCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("S")) {
                    startRow = row;
                    starCol = col;
                    break;
                }
            }
        }
        return new int[]{startRow, starCol};
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
