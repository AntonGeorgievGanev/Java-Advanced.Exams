package Exams.E16December2020;

import java.util.Scanner;

public class Selling_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        int money = 0;
        boolean isOut = false;

        for (int row = 0; row < n; row++) {
            String[] data = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = data[col];
            }
        }
        int currentRow = findInitialPosition(matrix)[0];
        int currentCol = findInitialPosition(matrix)[1];
        matrix[currentRow][currentCol] = "-";

        String direction = scanner.nextLine();
        while (money < 50) {
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
            } else if (Character.isDigit(matrix[currentRow][currentCol].charAt(0))) {
                money += Integer.parseInt(matrix[currentRow][currentCol]);
                matrix[currentRow][currentCol] = "-";
            } else if (matrix[currentRow][currentCol].equals("O")) {
                matrix[currentRow][currentCol] = "-";
                currentRow = findExitPillar(matrix)[0];
                currentCol = findExitPillar(matrix)[1];
                matrix[currentRow][currentCol] = "-";
            }
            if (money >= 50) {
                break;
            }
            direction = scanner.nextLine();
        }
        if (isOut) {
            System.out.println("Bad news, you are out of the bakery.");
        } else if (money >= 50) {
            matrix[currentRow][currentCol] = "S";
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);
        printMatrix(matrix);
    }

    public static int[] findInitialPosition(String[][] matrix) {
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

    public static int[] findExitPillar(String[][] matrix) {
        int pillarRow = -1;
        int pillarCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("O")) {
                    pillarRow = row;
                    pillarCol = col;
                    break;
                }
            }
        }
        return new int[]{pillarRow, pillarCol};
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
