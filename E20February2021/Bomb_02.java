package Exams.E20February2021;

import java.util.Scanner;

public class Bomb_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[fieldSize][fieldSize];
        String[] commands = scanner.nextLine().split(",");

        for (int row = 0; row < fieldSize; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < fieldSize; col++) {
                matrix[row][col] = data[col];
            }
        }

        int currentRow = findStartPosition(matrix)[0];
        int currentCol = findStartPosition(matrix)[1];
        matrix[currentRow][currentCol] = "+";
        int countOfBombs = countBombs(matrix);

        for (int i = 0; i < commands.length; i++) {
            String direction = commands[i];

            switch (direction) {
                case "up":
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow++;
                    }
                    break;
                case "down":
                    currentRow++;
                    if (currentRow > fieldSize - 1) {
                        currentRow--;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (currentCol > fieldSize - 1) {
                        currentCol--;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol++;
                    }
                    break;
            }
            if (matrix[currentRow][currentCol].equals("B")) {
                matrix[currentRow][currentCol] = "+";
                countOfBombs--;
                System.out.println("You found a bomb!");
                if (countOfBombs == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[currentRow][currentCol].equals("e")) {
                System.out.printf("END! %d bombs left on the field", countOfBombs);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countOfBombs, currentRow, currentCol);
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

    public static int countBombs(String[][] matrix) {
        int countBombs = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("B")) {
                    countBombs++;
                }
            }
        }
        return countBombs;
    }
}
