package dp;

public class UniquePaths2 {
    public static void main(String[] args) {

    }
}

// class UniquePaths2_Memoiz_Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length , n = obstacleGrid[0].length;

//         if (obstacleGrid[0][0] == 1) return 0;

//         int [][] dp = new int[m][n];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 dp[i][j] = -1;
//             }
//         }

//         return uniquePaths(obstacleGrid, 0, 0, dp);
//     }

//     public int uniquePaths(int[][] obstacleGrid, int m, int n, int[][] dp) {
//         // System.out.println("m=" + m + " n=" + n);

//         if (m > obstacleGrid.length - 1 || n > obstacleGrid[0].length - 1) return 0;

//         if (dp[m][n] != -1)
//             return dp[m][n];

//         if (obstacleGrid[m][n] != 1 && m == obstacleGrid.length - 1
//             && n == obstacleGrid[0].length - 1)
//              return 1;

//         if (obstacleGrid[m][n] == 1)
//             return 0;

//         return dp[m][n] = uniquePaths(obstacleGrid, m + 1, n, dp) +
//                             uniquePaths(obstacleGrid, m, n + 1, dp);
//     }
// }



// class UniquePaths2Solution {
//     public int uniquePathsWithObstacles(int[][] obsGrid) {
//         if (obsGrid[0][0] == 1) return 0;

//         int m = obsGrid.length , n = obsGrid[0].length;

//         int[][] dp = new int[m][n];

//         boolean isRow = true;
//         boolean isColumn = true;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == 0 || j == 0) {
//                     if (obsGrid[i][j] == 1) {
//                         if (i == 0) {
//                             isRow = false;
//                         }

//                         if (j == 0) {
//                             isColumn = false;
//                         }
//                     }

//                     dp[i][j] = 1;

//                     if (i == 0 && !isRow)
//                         dp[i][j] = 0;

//                     if (j == 0 && !isColumn)
//                         dp[i][j] = 0;

//                 } else {
//                     if (obsGrid[i][j] == 1) {
//                         dp[i][j] = 0;
//                     } else {
//                         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                     }
//                 }
//             }
//         }

//         return dp[m - 1][n - 1];
//     }
// }


class UniquePaths2_Solution {
    public int uniquePathsWithObstacles(int[][] obsGrid) {
        if (obsGrid[0][0] == 1) return 0;

        int m = obsGrid.length , n = obsGrid[0].length;

        int[][] dp = new int[m][n];

        boolean isRow = true;
        boolean isColumn = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (obsGrid[i][j] == 1) {
                        if (i == 0) {
                            isRow = false;
                        }

                        if (j == 0) {
                            isColumn = false;
                        }
                    }

                    dp[i][j] = 1;

                    if (i == 0 && !isRow)
                        dp[i][j] = 0;

                    if (j == 0 && !isColumn)
                        dp[i][j] = 0;

                } else {
                    if (obsGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
