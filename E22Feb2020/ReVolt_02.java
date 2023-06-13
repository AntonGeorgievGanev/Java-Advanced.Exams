package Exams.E22Feb2020;

import java.util.Scanner;

public class ReVolt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] data = scanner.nextLine().split("");
            matrix[row] = data;
        }

        int currentRow = findStartPosition(matrix)[0];
        int currentCol = findStartPosition(matrix)[1];
        matrix[currentRow][currentCol] = "-";
        boolean finish = false;

        for (int i = 0; i < countOfCommands; i++) {
            String direction = scanner.nextLine();
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
                        currentCol = size - 1;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("B")) {
                if (direction.equals("up")) {
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow = matrix.length - 1;
                    }
                } else if (direction.equals("down")) {
                    currentRow++;
                    if (currentRow > matrix.length - 1) {
                        currentRow = 0;
                    }
                } else if (direction.equals("right")) {
                    currentCol++;
                    if (currentCol > matrix.length - 1) {
                        currentCol = 0;
                    }
                } else if (direction.equals("left")) {
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol = matrix.length - 1;
                    }
                }
            } else if (matrix[currentRow][currentCol].equals("T")) {
                if (direction.equals("up")) {
                    currentRow++;
                    if (currentRow > matrix.length - 1) {
                        currentRow = 0;
                    }
                } else if (direction.equals("down")) {
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow = matrix.length - 1;
                    }
                } else if (direction.equals("right")) {
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol = matrix.length - 1;
                    }

                } else if (direction.equals("left")) {
                    currentCol++;
                    if (currentCol > matrix.length - 1) {
                        currentCol = 0;
                    }
                }
            }
            if (matrix[currentRow][currentCol].equals("F")) {
                finish = true;
            }
            if (finish){
                break;
            }
        }
        matrix[currentRow][currentCol] = "f";
        if (finish) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    public static int[] findStartPosition(String[][] matrix) {
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("f")) {
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
