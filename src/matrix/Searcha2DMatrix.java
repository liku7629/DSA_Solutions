package matrix;

// https://leetcode.com/problems/search-a-2d-matrix/description/
public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b = new Searcha2DMatrix_Optimal_Solution().searchMatrix(matrix, 3);
        System.out.println("result=" + b);
    }
}

class Searcha2DMatrix_BruteForce_Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}


class Searcha2DMatrix_Optimal_Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {

            // if target is >= first element in row and <= last element in a row the search in that row
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {

                //inside the row search, this can be further optimized with binary search
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}