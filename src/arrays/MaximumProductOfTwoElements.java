package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;


//LeetCode 1464. Maximum Product of Two Elements in an Array
// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
// Soln: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/solutions/2844528/best-3-approaches-0ms-7ms-9ms-java/
// BruteForce: Sorted the input array in reverse order using priority queue
// Optimized:
public class MaximumProductOfTwoElements {
    public static void main(String[] args) {
        System.out.println(new MaximumProductOfTwoElements_BruteForce_Solution().maxProduct(new int[] {3,4,5,2}));
    }
}

class MaximumProductOfTwoElements_BruteForce_Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        return (queue.poll() - 1) * (queue.poll() - 1);
    }
}

class MaximumProductOfTwoElements_Optimized_Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return (max - 1) * (secondMax - 1);
    }
}
