package Exams.E15December2021;

import java.util.Scanner;

public class ThroneConquering_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[size][size];
        boolean dead = false;
        boolean findHelen = false;

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int parisRow = findParis(matrix)[0];
        int parisCol = findParis(matrix)[1];
        matrix[parisRow][parisCol] = '-';

        while (energy > 0){
            String[] command = scanner.nextLine().split("\\s+");
            String direction = command[0];
            int enemyRow = Integer.parseInt(command[1]);
            int enemyCol = Integer.parseInt(command[2]);
            matrix[enemyRow][enemyCol] = 'S';

            switch (direction){
                case"up":
                    if (parisRow - 1 >= 0){
                        parisRow--;
                    }
                    break;
                case"down":
                    if (parisRow + 1 < matrix.length){
                        parisRow++;
                    }
                    break;
                case"right":
                    if (parisCol + 1 < matrix.length){
                        parisCol++;
                    }
                    break;
                case"left":
                    if (parisCol - 1 >= 0){
                        parisCol--;
                    }
                    break;
            }
            energy--;

            if (energy <= 0){
                dead = true;
                matrix[parisRow][parisCol] = 'X';
                break;
            }

            if (matrix[parisRow][parisCol] == 'H'){
                findHelen = true;
                matrix[parisRow][parisCol] = '-';
                break;
            }else if (matrix[parisRow][parisCol] == 'S'){
                energy -= 2;
                if (energy <= 0){
                    dead = true;
                    matrix[parisRow][parisCol] = 'X';
                    break;
                }
                matrix[parisRow][parisCol] = '-';
            }

        }
        if (findHelen){
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }
        if (dead){
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }
        printMatrix(matrix);
    }

    public static int[] findParis(char[][] matrix) {
        int parisRow = -1;
        int parisCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                    break;
                }
            }
        }
        return new int[]{parisRow, parisCol};
    }

    public static void printMatrix(char[][] matrix){
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
