package Exams.E13April2022;

import java.util.Scanner;

public class Armory_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        for (int row = 0; row < n; row++) {
            String[] data = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = data[col];
            }
        }

        int currentRow = findInitialPosition(matrix)[0];
        int currentCol = findInitialPosition(matrix)[1];
        matrix[currentRow][currentCol] = "-";
        int goldCoins = 0;
        String command = scanner.nextLine();
        boolean outOfArmory = false;
        while (goldCoins < 65) {
            switch (command) {
                case "up":
                    currentRow--;
                    if (currentRow < 0) {
                        outOfArmory = true;
                    }
                    break;
                case "down":
                    currentRow++;
                    if (currentRow > n - 1) {
                        outOfArmory = true;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (currentCol > n - 1) {
                        outOfArmory = true;
                        break;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (currentCol < 0) {
                        outOfArmory = true;
                    }
                    break;
            }
            if (outOfArmory) {
                break;
            }

            if (Character.isDigit(matrix[currentRow][currentCol].charAt(0))) {
                goldCoins += Integer.parseInt(matrix[currentRow][currentCol]);
                matrix[currentRow][currentCol] = "-";
            } else if (matrix[currentRow][currentCol].equals("M")) {
                matrix[currentRow][currentCol] = "-";
                currentRow = findExitMirror(matrix)[0];
                currentCol = findExitMirror(matrix)[1];
                matrix[currentRow][currentCol] = "-";
            }
            if (goldCoins >= 65) {
                break;
            }
            command = scanner.nextLine();
        }

        if (outOfArmory) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
            matrix[currentRow][currentCol] = "A";
        }
        System.out.printf("The king paid %d gold coins.%n", goldCoins);
        printMatrix(matrix);
    }

    public static int[] findInitialPosition(String[][] matrix) {
        int initialRow = -1;
        int initialCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("A")) {
                    initialRow = row;
                    initialCol = col;
                    break;
                }
            }
        }
        return new int[]{initialRow, initialCol};
    }

    public static int[] findExitMirror(String[][] matrix) {
        int rowM = -1;
        int colM = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("M")) {
                    rowM = row;
                    colM = col;
                }
            }
        }
        return new int[]{rowM, colM};
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
