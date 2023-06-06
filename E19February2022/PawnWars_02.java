package Exams.E19February2022;

import java.util.Scanner;

public class PawnWars_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];
        for (int row = 0; row < matrix.length; row++) {
            String[] data = scanner.nextLine().split("");
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = data[col];
            }
        }
        boolean whiteWins = false;
        boolean blackWins = false;
        boolean whiteQueen = false;
        boolean blackQueen = false;

        int whiteRow = findWhitePawn(matrix)[0];
        int whiteCol = findWhitePawn(matrix)[1];
        matrix[whiteRow][whiteCol] = "-";
        int blackRow = findBlackPawn(matrix)[0];
        int blackCol = findBlackPawn(matrix)[1];
        matrix[blackRow][blackCol] = "-";

        while (whiteRow != 0 && blackRow != matrix.length - 1) {

            if (whiteRow - 1 == blackRow && whiteCol + 1 == blackCol) {
                whiteWins = true;
                break;
            }

            if (whiteRow - 1 == blackRow && whiteCol - 1 == blackCol) {
                whiteWins = true;
                break;
            }
            whiteRow--;
            if (whiteRow == 0) {
                whiteQueen = true;
                break;
            }

            if (blackRow + 1 == whiteRow && blackCol - 1 == whiteCol) {
                blackWins = true;
                break;
            }

            if (blackRow + 1 == whiteRow && blackCol + 1 == whiteCol) {
                blackWins = true;
                break;
            }

            blackRow++;
            if (blackRow == matrix.length - 1) {
                blackQueen = true;
                break;
            }
        }

        if (whiteQueen) {
            System.out.printf("Game over! White pawn is promoted to a queen at %s.", convertCoordinates(whiteRow, whiteCol));
        }

        if (whiteWins) {
            System.out.printf("Game over! White capture on %s.", convertCoordinates(blackRow, blackCol));
        }

        if (blackWins) {
            System.out.printf("Game over! Black capture on %s.", convertCoordinates(whiteRow, whiteCol));
        }

        if (blackQueen) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.", convertCoordinates(blackRow, blackCol));
        }
    }
    public static int[] findWhitePawn(String[][] matrix) {
        int whiteRow = -1;
        int whiteCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("w")) {
                    whiteRow = row;
                    whiteCol = col;
                    break;
                }
            }
        }
        return new int[]{whiteRow, whiteCol};
    }
    public static int[] findBlackPawn(String[][] matrix) {
        int blackRow = -1;
        int blackCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("b")) {
                    blackRow = row;
                    blackCol = col;
                    break;
                }
            }
        }
        return new int[]{blackRow, blackCol};
    }
    public static String convertCoordinates(int row, int col) {
        int convertedRow = 8 - row;
        char convertedCol = (char) ('a' + col);
        return String.valueOf(convertedCol) + convertedRow;
    }
}
