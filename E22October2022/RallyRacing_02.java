package Exams.E22October2022;

import java.util.Scanner;

public class RallyRacing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        String[][] matrix = new String[size][size];
        int kmPassed = 0;
        boolean finish = false;

        for (int row = 0; row < size; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = data[col];
            }
        }
        int currentRow = 0;
        int currentCol = 0;

        String direction = scanner.nextLine();
        while (!direction.equals("End")){
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

            if (matrix[currentRow][currentCol].equals("F")){
                finish = true;
                kmPassed += 10;
                matrix[currentRow][currentCol] = "C";
                break;
            }else if (matrix[currentRow][currentCol].equals(".")){
                kmPassed += 10;
            }else if (matrix[currentRow][currentCol].equals("T")){
                kmPassed += 30;
                matrix[currentRow][currentCol] = ".";
                currentRow = findExitTunnel(matrix)[0];
                currentCol = findExitTunnel(matrix)[1];
                matrix[currentRow][currentCol] = ".";
            }
            direction = scanner.nextLine();
        }
        if (finish){
            System.out.printf("Racing car %s finished the stage!%n", carNumber);
        }else{
            matrix[currentRow][currentCol] = "C";
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", kmPassed);
        printMatrix(matrix);
    }

    public static int[] findExitTunnel (String[][] matrix){
        int tunnelRow = -1;
        int tunnelCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("T")){
                    tunnelRow = row;
                    tunnelCol = col;
                }
            }
        }
        return new int[]{tunnelRow, tunnelCol};
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
