package Exams.E18August2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        List<String> correctPath = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                //the given row data length may not be equal to the cols(is less and must be refilled)
                if (col < data.length) {
                    matrix[row][col] = data[col];
                }else{
                    matrix[row][col] = "-";
                }
            }
        }
        int currentRow = findInitialPosition(matrix)[0];
        int currentCol = findInitialPosition(matrix)[1];
        String direction = scanner.nextLine();

        while (!direction.equals("Finish")) {
            if (direction.equals("up") || direction.equals("down") || direction.equals("right") || direction.equals("left")) {
                switch (direction) {
                    case "up":
                        if (currentRow - 1 >= 0 && !matrix[currentRow - 1][currentCol].equals("T")) {
                            currentRow--;
                            correctPath.add(direction);
                        }
                        break;
                    case "down":
                        if (currentRow + 1 < rows && !matrix[currentRow + 1][currentCol].equals("T")) {
                            currentRow++;
                            correctPath.add(direction);
                        }
                        break;
                    case "right":
                        if (currentCol + 1 < cols && !matrix[currentRow][currentCol + 1].equals("T")) {
                            currentCol++;
                            correctPath.add(direction);
                        }
                        break;
                    case "left":
                        if (currentCol - 1 >= 0 && !matrix[currentRow][currentCol - 1].equals("T")) {
                            currentCol--;
                            correctPath.add(direction);
                        }
                        break;
                }
            }
            direction = scanner.nextLine();
        }
        if (matrix[currentRow][currentCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is " + String.join(", ", correctPath));
        } else {
            System.out.print("The map is fake!");
        }
    }
    //87 test 4 runtime error
    //test 4 the given row data length is not equal to the cols(is less and must be refilled)

    public static int[] findInitialPosition(String[][] matrix) {
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("Y")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }
        return new int[]{startRow, startCol};
    }
}
