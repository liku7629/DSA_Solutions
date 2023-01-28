package matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    public static void main(String[] args) {

//        int matrix[][] = new int[][] {
//                { 10, 20, 30, 40 },
//                { 15, 25, 35, 45 },
//                { 27, 29, 37, 48 },
//                { 32, 33, 39, 50 }
//        };

//        int matrix[][] = new int[][]{
//                {10, 20, 30},
//                {15, 25, 35},
//        };

//        printSnakePattern(matrix);
//        printMByNMatrix(5, 2);
//        spiralOrder(matrix);
//        transpose(matrix);
//        transposeWithTempMatrix(matrix);

        int matrix[][] = new int[][]{
                {1,5,9},
                {10,11,13, 17},
                {12,13,15, 18}
        };

//        kthSmallest(matrix, 8);
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("i=" + i + " j=" + j + " val=" + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void printMByNMatrix(int m, int n) {
        int[][] matix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printSnakePattern(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }

    public static int[][] transposeWithTempMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] temp = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[j][i] = matrix[i][j];
            }
        }

        return temp;
    }

    public static int[][] transpose(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while(low < high){
            int mid = low + (high - low)/2;
            int count = lessEqual(matrix,mid);
            if(count < k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;

    }

    //from left bottom or right top we can count how many numbers are equal or less than our target

    public static int lessEqual(int[][] matrix, int target){
        int count = 0 , len = matrix.length, i = len-1, j=0;

        while(i >=0 && j<len){
            if(matrix[i][j] > target){
                i--;
            }
            else
            {
                count = count + i +1;
                j++;
            }
        }
        return count;
    }
}
