package Exams.E23October2021;

import java.util.Scanner;

public class MouseAndCheese_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        int cheeseCount = 0;
        boolean mouseIsOut = false;

        for (int row = 0; row < n; row++) {
            String[] data = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = data[col];
            }
        }

        int currentRow = findMouse(matrix)[0];
        int currentCol = findMouse(matrix)[1];
        matrix[currentRow][currentCol] = "-";
        String direction = scanner.nextLine();
        while (!direction.equals("end")){
            switch (direction){
                case"up":
                    currentRow--;
                    break;
                case"down":
                    currentRow++;
                    break;
                case"right":
                    currentCol++;
                    break;
                case"left":
                    currentCol--;
                    break;
            }

            if (currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= n){
                mouseIsOut = true;
                break;
            }else if (matrix[currentRow][currentCol].equals("c")){
                cheeseCount++;
                matrix[currentRow][currentCol] = "-";
            }else if (matrix[currentRow][currentCol].equals("B")){
                matrix[currentRow][currentCol] = "-";
                continue;
            }
            direction = scanner.nextLine();
        }
        if (mouseIsOut){
            System.out.println("Where is the mouse?");
        }else{
            matrix[currentRow][currentCol] = "M";
        }

        if (cheeseCount < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCount);
        }else{
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseCount);
        }
        printMatrix(matrix);
    }

    public static int[] findMouse (String[][] matrix){
        int mouseRow = -1;
        int mouseCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("M")){
                    mouseRow = row;
                    mouseCol = col;
                    break;
                }
            }
        }

        return new int[]{mouseRow, mouseCol};
    }

    public static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
