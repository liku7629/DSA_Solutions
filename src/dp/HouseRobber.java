package dp;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        new Solution_House_Robber_Recursion().rob(new int[] {1, 2, 3, 4, 5});
    }
}

 class Solution_House_Robber_Recursion {
     public int rob(int[] nums) {
         int[] cache = new int[nums.length];
         Arrays.fill(cache, -1);
         return rob(nums, nums.length - 1, cache);
     }

     public int rob(int[] nums, int i, int[] cache) {
         System.out.println(Arrays.toString(cache));
         if (i < 0) {
             return 0;
         }

         if (cache[i] != -1) {
             return cache[i];
         }

         int take = rob(nums, i - 2, cache) + nums[i];

         int notTake = rob(nums, i - 1, cache);

         return cache[i] = Math.max(notTake, take);
     }
 }

 class Solution_House_Robber_Tabulation {
     public int rob(int[] nums) {
         if (nums.length == 1) {
             return nums[0];
         }


         int[] dp = new int[nums.length];
         dp[0] = nums[0];
         dp[1] = Math.max(nums[0], nums[1]);

         for (int i = 2; i < nums.length; i++) {
             int take = nums[i] + dp[i - 2];
             int notTake = dp[i - 1];
             dp[i] = Math.max(take, notTake);
                     // System.out.println("i=" + i + " take=" + take + " notTake=" + notTake + "  " + Arrays.toString(dp));

         }

         return dp[nums.length - 1];
     }
 }

class Solution_House_Robber_Space_Optimization {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = nums[0], prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int take = prev2 + nums[i];
            prev2 = prev;
            prev = Math.max(take, prev);
        }

        return prev;
    }
}
