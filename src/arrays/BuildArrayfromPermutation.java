package arrays;

public class BuildArrayfromPermutation {
    public static void main(String[] args) {

    }
}

class BuildArrayfromPermutation_BruteForce_Solution {
    public int[] buildArray(int[] nums) {
        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            results[i] = nums[nums[i]];
        }

        return results;
    }
}


/**
 * * The idea is to use the fact that we can store two values in one index.
 *
 * We can do that using the formula: nums[i] = nums[i] + (nums[nums[i]] % n) * n
 *
 * [5, 0, 1, 2, 3, 4] n = 6
 *
 * i = 0
 * old = 5,
 * new = nums[5] % n = 4
 * replaceValue = 4 × 6 + 5 = 29
 *
 * → [29, 0, 1, 2, 3, 4]
 *
 * i = 1
 * old = 0,
 * new = nums[0] % n = 29 % 6 = 5
 * replaceValue = 5 × 6 + 0 = 30
 *
 * → [29, 30, 1, 2, 3, 4]
 *
 * Final
 * nums[i] // n
 * → 4, 5, 0, 1, 2, 3
 */

class BuildArrayfromPermutation_Optimized_Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }

        return nums;
    }
}