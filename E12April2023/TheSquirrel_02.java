package Exams.E12April2023;

import java.util.Scanner;

public class TheSquirrel_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        int hazelnuts = 0;

        String[][] matrix = new String[size][size];
        for (int row = 0; row < size; row++) {
            String[] data = scanner.nextLine().split("");
            matrix[row] = data;
        }

        int currentRow = findStartPosition(matrix)[0];
        int currentCol = findStartPosition(matrix)[1];
        matrix[currentRow][currentCol] = "*";

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command){
                case"up":
                    currentRow--;
                    if (outOfField(currentRow, currentCol, size)){
                        System.out.println("The squirrel is out of the field.");
                        System.out.printf("Hazelnuts collected: %d", hazelnuts);
                        return;
                    }
                    break;
                case"down":
                    currentRow++;
                    if (outOfField(currentRow, currentCol, size)){
                        System.out.println("The squirrel is out of the field.");
                        System.out.printf("Hazelnuts collected: %d", hazelnuts);
                        return;
                    }
                    break;
                case"right":
                    currentCol++;
                    if (outOfField(currentRow, currentCol, size)){
                        System.out.println("The squirrel is out of the field.");
                        System.out.printf("Hazelnuts collected: %d", hazelnuts);
                        return;
                    }
                    break;
                case"left":
                    currentCol--;
                    if (outOfField(currentRow, currentCol, size)){
                        System.out.println("The squirrel is out of the field.");
                        System.out.printf("Hazelnuts collected: %d", hazelnuts);
                        return;
                    }
                    break;
            }
            if (matrix[currentRow][currentCol].equals("t")){
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                System.out.printf("Hazelnuts collected: %d", hazelnuts);
                return;
            }else if (matrix[currentRow][currentCol].equals("h")){
                matrix[currentRow][currentCol] = "*";
                hazelnuts++;
                if (hazelnuts == 3){
                    System.out.println("Good job! You have collected all hazelnuts!");
                    System.out.printf("Hazelnuts collected: %d", hazelnuts);
                    return;
                }
            }
        }
        System.out.println("There are more hazelnuts to collect.");
        System.out.printf("Hazelnuts collected: %d", hazelnuts);
    }
    public static int[] findStartPosition(String[][] matrix){
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("s")){
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }
        return new int[]{startRow, startCol};
    }

    public static boolean outOfField(int currentRow, int currentCol, int size){
        if ((currentRow >= 0 && currentRow <= size - 1) && (currentCol >= 0 && currentCol <= size - 1)){
            return false;
        }
        return true;
    }
}
