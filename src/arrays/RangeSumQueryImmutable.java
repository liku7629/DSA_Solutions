package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/range-sum-query-immutable/description/
public class RangeSumQueryImmutable {

}

// Bruteforce
//
class RangeSumQueryImmutable_BruteForce_NumArray {

    int[] nums;

    public RangeSumQueryImmutable_BruteForce_NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }
}


// Pre compute all the sums in during in constructer call
class RangeSumQueryImmutable_Optimal_NumArray {
    private int[] sums;

    public RangeSumQueryImmutable_Optimal_NumArray(int[] nums) {
        // added length + 1 to avoid IndexOutOfBoundException during sums[right + 1]
        sums = new int[nums.length + 1];
        int sum = 0;

        for (int i = 1; i < sums.length; i++) {
            sum += nums[i - 1];
            sums[i] = sum;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sums));
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
