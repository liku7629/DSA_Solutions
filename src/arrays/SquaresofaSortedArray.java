package arrays;

import java.util.Arrays;

public class SquaresofaSortedArray {
    public static void main(String[] args) {
//        System.out.println(new SquaresofaSortedArray_Optimal_Solution().sortedSquares(new int[] {-4,-1,0,3,10}));
        System.out.println(new Solution().sortedSquares(new int[] {-7,-3,2,3,11}));
    }
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int pos = n - 1;

        int[] result = new int[n];

        while (left < right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[pos] = nums[left] * nums[left];
                left++;
            } else {
                result[pos] = nums[right] * nums[right];
                right--;
            }
            pos--;
        }

        return result;
    }
}

class SquaresofaSortedArray_Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }
}

// we will take two pointers left and right
// we will check if abs(left) > abs(right) add left * left to result array
class SquaresofaSortedArray_Optimal_Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int element;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                element = nums[right];
                right--;
            } else {
                element = nums[left];
                left++;
            }

            result[i] = element * element;
        }

        return result;
    }
}