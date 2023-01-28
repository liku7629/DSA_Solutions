package matrix;

public class SetMatrixZero {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 0, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new Solution().setZeroes(matrix);
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;

        //first row
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
            }
        }

        //first column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.println("i=" + i + " j=" + j + " val=" + matrix[i][j]);
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}