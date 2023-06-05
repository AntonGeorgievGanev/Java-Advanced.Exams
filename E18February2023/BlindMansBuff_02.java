package Exams.E18February2023;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int countOfMoves = 0;

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] data = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = data[col];
            }
        }

        int currentRow = findInitialPosition(matrix)[0];
        int currentCol = findInitialPosition(matrix)[1];
        int touchedOpponents = 0;
        matrix[currentRow][currentCol] = "-";
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow++;
                        command = scanner.nextLine();
                        continue;
                    }
                    if (matrix[currentRow][currentCol].equals("O")) {
                        currentRow++;
                        command = scanner.nextLine();
                        continue;
                    }
                    if (matrix[currentRow][currentCol].equals("-")) {
                        matrix[currentRow + 1][currentCol] = "-";
                    }

                    break;
                case "down":
                    currentRow++;
                    if (currentRow >= rows) {
                        currentRow--;
                        command = scanner.nextLine();
                        continue;
                    }
                    if (matrix[currentRow][currentCol].equals("O")) {
                        currentRow--;
                        command = scanner.nextLine();
                        continue;
                    }
                    if (matrix[currentRow][currentCol].equals("-")) {
                        matrix[currentRow - 1][currentCol] = "-";
                    }

                    break;
                case "left":
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol++;
                        command = scanner.nextLine();
                        continue;
                    }
                    if (matrix[currentRow][currentCol].equals("O")) {
                        currentCol++;
                        command = scanner.nextLine();
                        continue;
                    }
                    if (matrix[currentRow][currentCol].equals("-")) {
                        matrix[currentRow][currentCol + 1] = "-";
                    }

                    break;
                case "right":
                    currentCol++;
                    if (currentCol >= rows) {
                        currentCol--;
                        command = scanner.nextLine();
                        continue;
                    }
                    if (matrix[currentRow][currentCol].equals("O")) {
                        currentCol--;
                        command = scanner.nextLine();
                        continue;
                    }
                    if (matrix[currentRow][currentCol].equals("-")) {
                        matrix[currentRow][currentCol - 1] = "-";
                    }

                    break;
            }
            if (matrix[currentRow][currentCol].equals("P")) {
                touchedOpponents++;
                matrix[currentRow][currentCol] = "-";
            }
            countOfMoves++;
            if (touchedOpponents == 3) {
                break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, countOfMoves);
    }

    public static int[] findInitialPosition(String[][] matrix) {
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }
        return new int[]{startRow, startCol};
    }
}
