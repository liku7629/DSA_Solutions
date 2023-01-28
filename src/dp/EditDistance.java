package dp;

public class EditDistance {
    public static void main(String[] args) {
//        int i = new EditDistance().editDistance("horse", "ros");
        long startTime = System.currentTimeMillis();

        int i = new EditDistance().editDistance("dinitrophenylhydrazine",
                "benzalphenylhydrazone");
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Total Time: " + totalTime);

        System.out.println("distance:" + i);
    }

//    public int editDistance(String w1, String w2) {
//        return editDistance(w1, w2, w1.length(), w2.length());
//    }
//
//    public int editDistance(String w1, String w2, int m, int n) {
//        if (m == 0) return n;
//        if (n == 0) return m;
//
//        if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
//            return editDistance(w1, w2, m - 1, n - 1);
//        }
//
//        return 1 + min(
//                editDistance(w1, w2, m - 1, n),
//                editDistance(w1, w2, m - 1, n - 1),
//                editDistance(w1, w2, m, n - 1)
//        );
//    }


    public int editDistance(String w1, String w2) {
        int[][] dp = new int[w1.length() + 1][w2.length() + 1];

        for(int i = 0; i < w1.length() + 1; i++) {
            for(int j = 0; j < w2.length() + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return editDistance(w1, w2, w1.length(), w2.length(), dp);
    }

    public int editDistance(String w1, String w2, int m, int n, int[][] dp) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (dp[m][n] != - 1) {
            return dp[m][n];
        }

        if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
            return dp[m][n] = editDistance(w1, w2, m - 1, n - 1, dp);
        }

        return dp[m][n] = 1 + min(
                editDistance(w1, w2, m - 1, n, dp),
                editDistance(w1, w2, m - 1, n - 1, dp),
                editDistance(w1, w2, m, n - 1, dp)
        );
    }

    public static int min(int m1, int m2, int m3) {
        return Math.min(m1, Math.min(m2, m3));
    }
}
