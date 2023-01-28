package dp;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubSequence {
    public static void main(String[] args) {
//        int longestCommonSubsequence = new LongestCommonSubSequence().longestCommonSubsequence("abcder", "acerty");
        long startTime = System.currentTimeMillis();
        int longestCommonSubsequence = new LongestCommonSubSequence().longestCommonSubsequence("pmjghexybyrgzczy",
                "hafcdqbgncrcbihkd");
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Total Time: " + totalTime);
        System.out.println(longestCommonSubsequence);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][ text2.length() + 1];

        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return longestCommonSubsequence(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    public int longestCommonSubsequenceBruteForce(String text1, String text2, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (text1.charAt(m) == text2.charAt(n)) {
            return 1 + longestCommonSubsequenceBruteForce(text1, text2, m - 1, n - 1);
        }

        return Math.max(
                longestCommonSubsequenceBruteForce(text1, text2, m - 1, n),
                longestCommonSubsequenceBruteForce(text1, text2, m, n -1)
        );
    }

    public int longestCommonSubsequence(String text1, String text2, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (text1.charAt(m) == text2.charAt(n)) {
            return dp[m][n] = 1 + longestCommonSubsequence(text1, text2, m - 1, n - 1, dp);
        }

        return dp[m][n] = Math.max(
                longestCommonSubsequence(text1, text2, m - 1, n, dp),
                longestCommonSubsequence(text1, text2, m, n -1, dp)
        );
    }
}
