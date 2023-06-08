package Exams.E18August2021;

import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commandCount = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        boolean finish = false;

        for (int row = 0; row < n; row++) {
            String[] data = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = data[col];
            }
        }

        int currentRow = getInitialPosition(matrix)[0];
        int currentCol = getInitialPosition(matrix)[1];
        matrix[currentRow][currentCol] = ".";


        for (int i = 0; i < commandCount; i++) {
            String direction = scanner.nextLine();
            switch (direction){
                case"up":
                    currentRow--;
                    if (currentRow < 0){
                        currentRow = matrix.length - 1;
                    }
                    break;
                case"down":
                    currentRow++;
                    if (currentRow > matrix.length - 1){
                        currentRow = 0;
                    }
                    break;
                case"right":
                    currentCol++;
                    if (currentCol > matrix.length - 1){
                        currentCol = 0;
                    }
                    break;
                case"left":
                    currentCol--;
                    if (currentCol < 0){
                        currentCol = matrix.length - 1;
                    }
                    break;
            }
            if (matrix[currentRow][currentCol].equals("B")){
                if (direction.equals("up")){
                    currentRow--;
                    if (currentRow < 0){
                        currentRow = matrix.length - 1;
                    }
                }else if (direction.equals("down")){
                    currentRow++;
                    if (currentRow > matrix.length - 1){
                        currentRow = 0;
                    }
                }else if (direction.equals("right")){
                    currentCol++;
                    if (currentCol > matrix.length - 1){
                        currentCol = 0;
                    }
                }else if (direction.equals("left")){
                    currentCol--;
                    if (currentCol < 0){
                        currentCol = matrix.length - 1;
                    }
                }
            }else if (matrix[currentRow][currentCol].equals("T")){
                if (direction.equals("up")){
                    currentRow++;
                    if (currentRow < 0){
                        currentRow = matrix.length - 1;
                    }
                }else if (direction.equals("down")){
                    currentRow--;
                    if (currentRow > matrix.length - 1){
                        currentRow = 0;
                    }
                }else if (direction.equals("right")){
                    currentCol--;
                    if (currentCol > matrix.length - 1){
                        currentCol = 0;
                    }
                }else if (direction.equals("left")){
                    currentCol++;
                    if (currentCol < 0){
                        currentCol = matrix.length - 1;
                    }
                }
            }
            if (matrix[currentRow][currentCol].equals("F")){
                matrix[currentRow][currentCol] = "P";
                finish = true;
                break;
            }
        }

        if (finish){
            System.out.println("Well done, the player won first place!");
        }else{
            System.out.println("Oh no, the player got lost on the track!");
            matrix[currentRow][currentCol] = "P";
        }

        printMatrix(matrix);
    }

    public static int[] getInitialPosition(String[][] matrix){
        int carRow = -1;
        int carCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length ; col++) {
                if (matrix[row][col].equals("P")){
                    carRow = row;
                    carCol = col;
                    break;
                }
            }
        }
        return new int[]{carRow, carCol};
    }

    public static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
