package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class PartitionEqualSubSetSum {
    public static void main(String[] args) {
//        boolean canPartition = new PartitionEqualSubSetSum().canPartition(new int[]{1, 4, 12, 5});
        boolean canPartition = new PartitionEqualSubSetSum().canPartition(new int[]{1, 5, 11, 5});
//        boolean canPartition = new PartitionEqualSubSetSum().canPartition(new int[]{1, 5, 11, 5}, 4);
        System.out.println("canPartition: " + canPartition);
    }

    public boolean canPartition(int[] nums) {
        int target = 0;

        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }

        if (target % 2 != 0) {
            return false;
        }

        return canPartition(nums, 0, target / 2);
    }

    public boolean canPartition(int[] nums, int i, int target) {
        if (target == 0) return true;

        if (i == nums.length && target != 0) return false;

        boolean canPartition1 = canPartition(nums, i + 1, target - nums[i]);

        if (canPartition1) return true;

        boolean canPartition2 = canPartition(nums, i + 1, target);

        if (canPartition2) return true;

        return false;
    }

        // A utility function that returns true if there is a
        // subset of arr[] with sum equal to given sum
        static boolean isSubsetSum(int arr[], int n, int sum) {
            // Base Cases
            if (sum == 0)
                return true;
            if (n == 0 && sum != 0)
                return false;

            // If last element is greater than sum, then ignore
            // it
            if (arr[n - 1] > sum)
                return isSubsetSum(arr, n - 1, sum);

		/* else, check if sum can be obtained by any of
		the following
		(a) including the last element
		(b) excluding the last element
		*/
            return isSubsetSum(arr, n - 1, sum)
                    || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
        }

        // Returns true if arr[] can be partitioned in two
        // subsets of equal sum, otherwise false
        static boolean findPartition(int arr[], int n) {
            // Calculate sum of the elements in array
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += arr[i];

            // If sum is odd, there cannot be two subsets
            // with equal sum
            if (sum % 2 != 0)
                return false;

            // Find if there is subset with sum equal to half
            // of total sum
            return isSubsetSum(arr, n, sum / 2);
        }

    }

