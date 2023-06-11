package Exams.E17Dec2019;

import java.util.Scanner;

public class PresentDelivery_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int santaPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        boolean noMorePresents = false;

        for (int row = 0; row < size; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            matrix[row] = data;
        }

        int countOfNiceKids = 0;
        int totalNiceKids = countOfNiceKids(matrix);
        int santaRow = findSantaPosition(matrix)[0];
        int santaCol = findSantaPosition(matrix)[1];
        matrix[santaRow][santaCol] = "-";

        String direction = scanner.nextLine();

        while (!direction.equals("Christmas morning")) {
            switch (direction) {
                case "up":
                    santaRow--;
                    break;
                case "down":
                    santaRow++;
                    break;
                case "right":
                    santaCol++;
                    break;
                case "left":
                    santaCol--;
                    break;
            }

            if (matrix[santaRow][santaCol].equals("V")) {
                santaPresents--;
                countOfNiceKids++;
                matrix[santaRow][santaCol] = "-";
            } else if (matrix[santaRow][santaCol].equals("X")) {
                matrix[santaRow][santaCol] = "-";
            } else if (matrix[santaRow][santaCol].equals("C")) {
                matrix[santaRow][santaCol] = "-";
                if (matrix[santaRow - 1][santaCol].equals("V") || matrix[santaRow - 1][santaCol].equals("X")) {
                    santaPresents--;
                    countOfNiceKids++;
                    matrix[santaRow - 1][santaCol] = "-";
                    if (santaPresents == 0) {
                        noMorePresents = true;
                    }
                }
                if (matrix[santaRow + 1][santaCol].equals("V") || matrix[santaRow + 1][santaCol].equals("X")) {
                    santaPresents--;
                    countOfNiceKids++;
                    matrix[santaRow + 1][santaCol] = "-";
                    if (santaPresents == 0) {
                        noMorePresents = true;
                    }
                }
                if (matrix[santaRow][santaCol + 1].equals("V") || matrix[santaRow][santaCol + 1].equals("X")) {
                    santaPresents--;
                    countOfNiceKids++;
                    matrix[santaRow][santaCol + 1] = "-";
                    if (santaPresents == 0) {
                        noMorePresents = true;
                    }
                }
                if (matrix[santaRow][santaCol - 1].equals("V") || matrix[santaRow][santaCol - 1].equals("X")) {
                    santaPresents--;
                    countOfNiceKids++;
                    matrix[santaRow][santaCol - 1] = "-";
                    if (santaPresents == 0) {
                        noMorePresents = true;
                    }
                }
            }
            if (santaPresents == 0) {
                noMorePresents = true;
                break;
            }
            direction = scanner.nextLine();
        }

        matrix[santaRow][santaCol] = "S";
        if (noMorePresents) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if (totalNiceKids - countOfNiceKids <= 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", countOfNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", totalNiceKids - countOfNiceKids);
        }
    }

    public static int[] findSantaPosition(String[][] matrix) {
        int santaRow = -1;
        int santaCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("S")) {
                    santaRow = row;
                    santaCol = col;
                    break;
                }
            }
        }
        return new int[]{santaRow, santaCol};
    }

    public static int countOfNiceKids(String[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("V")) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
