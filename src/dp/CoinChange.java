package dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
//        System.out.println(getCount(new int[] {2, 5, 3, 6}, 4, 10));
//        System.out.println(new CoinChange().coinChange(new int[] {2, 5, 3, 6},  10));
//        System.out.println(new CoinChange().coinChange(new int[] {1, 2},  4));
        System.out.println(new CoinChange().coinChange(new int[] {2},  3));

    }

    static int getCount(int coins[], int n, int sum) {
        if (sum == 0) return 1;

        if (n == 0) return 0;

        int res = getCount(coins, n - 1, sum);

        if (coins[n - 1] <= sum) {
            res = res + getCount(coins, n, sum - coins[n - 1]);
        }

        return res;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        int change = coinChange(coins, amount, dp);

        return change == Integer.MAX_VALUE ? -1 : change;
    }

    public int coinChange(int[] coins, int amount, int[] dp) {
        if (amount == 0)
            return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int subAns = 0;

                if (dp[amount - coins[i]] != -1) {
                    subAns = dp[amount - coins[i]];
                } else {
                    subAns = coinChange(coins, amount - coins[i], dp);
                }

                if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }

        return dp[amount] = ans;
    }


}
