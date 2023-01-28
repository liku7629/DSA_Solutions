package dp;

public class UniquePaths1 {
    public static void main(String[] args) {

    }
}

// class UniquePaths1_Memoization_Solution {
//   public int uniquePaths(int m, int n) {
//     int[][] dp = new int[m][n];
//     return uniquePath(m - 1, n - 1, dp);
//   }

// public int uniquePath(int m, int n, int[][] dp) {
//     if (m == 0 || n == 0) {
//       return 1;
//     }

//     if (dp[m][n] != 0) {
//         return dp[m][n];
//     }

//     // System.out.println("m=" + m + " n=" + n);

//     return dp[m][n] = uniquePath(m - 1, n, dp) + uniquePath(m, n - 1, dp);
//   }
// }



// class UniquePaths1_Optimized_Solution {
//   public int uniquePaths(int m, int n) {
//     int[][] dp = new int[m][n];

//     for (int i = 0; i < m; i++) {
//         for (int j = 0; j < n; j++) {
//             if (i == 0 || j == 0) {
//                 dp[i][j] = 1;
//             } else {
//                 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//             }
//         }
//     }

//     return dp[m - 1][n - 1];
//   }
// }


class UniquePaths1_Space_Optimized_Solution {
    public int uniquePaths(int m, int n) {
        int[] curr = new int[n];
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    curr[j] = 1;
                } else {
                    curr[j] = prev[j] + curr[j - 1];
                }
            }

            // System.out.println(" prev=" + Arrays.toString(prev));
            // System.out.println(" curr=" + Arrays.toString(curr) + " \n");

            prev = curr;
            curr = new int[n];
        }

        return prev[n - 1];
    }
}

