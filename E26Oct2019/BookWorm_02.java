package Exams.E26Oct2019;

import java.util.Scanner;

public class BookWorm_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] data = scanner.nextLine().split("");
            matrix[row] = data;
        }

        int currentRow = findStartPosition(matrix)[0];
        int currentCol = findStartPosition(matrix)[1];
        matrix[currentRow][currentCol] = "-";
        String direction = scanner.nextLine();

        while (!direction.equals("end")){
            boolean isOut = false;
            switch (direction){
                case"up":
                    currentRow--;
                    if (currentRow < 0){
                        currentRow++;
                        isOut = true;
                    }
                    break;
                case"down":
                    currentRow++;
                    if (currentRow > size - 1){
                        currentRow--;
                        isOut = true;
                    }
                    break;
                case"right":
                    currentCol++;
                    if (currentCol > size - 1){
                        currentCol--;
                        isOut = true;
                    }
                    break;
                case"left":
                    currentCol--;
                    if (currentCol < 0){
                        currentCol++;
                        isOut = true;
                    }
                    break;
            }
            if (isOut){
                if (builder.length() > 0){
                    builder.deleteCharAt(builder.length() - 1);
                }
            }else{
                if (!matrix[currentRow][currentCol].equals("-")){
                    builder.append(matrix[currentRow][currentCol]);
                    matrix[currentRow][currentCol] = "-";
                }
            }
            direction = scanner.nextLine();
        }
        matrix[currentRow][currentCol] = "P";
        System.out.println(builder);
        printMatrix(matrix);
    }

    public static int[] findStartPosition(String[][] matrix){
        int startRow = -1;
        int startCOl = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("P")){
                    startRow = row;
                    startCOl = col;
                    break;
                }
            }
        }
        return new int[]{startRow, startCOl};
    }

    public static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
