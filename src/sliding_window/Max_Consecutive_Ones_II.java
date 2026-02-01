package sliding_window;

import java.util.ArrayList;
import java.util.List;

public class Max_Consecutive_Ones_II {
    public static void main(String[] args) {

    }
}

class Max_Consecutive_Ones_II_Optimal_Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int lastZeroIndex = -1;
        int currCount = 0, maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && lastZeroIndex != -1) {
                currCount = i - lastZeroIndex;
                lastZeroIndex = i;
            } else if (nums[i] == 0) {
                currCount++;
                lastZeroIndex = i;
            } else {
                currCount++;
            }

            maxCount = Math.max(currCount, maxCount);
        }

        return maxCount;
    }
}

class Max_Consecutive_Ones_II_Striver_Optimal_Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int zeroCount = 0;
        int left = 0;

        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.length; ++right) {
            // If a zero is encountered, increment the zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            /* If there are more than 1 zero, move
             the left pointer to shrink the subarray */
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;  // Move left pointer to the right
            }

            // Update the maximum length of consecutive 1s
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
        }
        return maxConsecutiveOnes;
    }
}

class Max_Consecutive_Ones_II_Striver_Bruteforce_Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;

        List<Integer> zeroIndices = new ArrayList<>();

        // Traverse the array and collect indices of all zeros
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndices.add(i);
            }
        }

        /*If there are no zeros in the array,
      the entire array is all 1's, so return its length*/
        if (zeroIndices.isEmpty()) {
            return nums.length;
        }

        /* Simulate flipping each zero to 1 and
        calculate the maximum consecutive 1's*/
        for (int flipIndex : zeroIndices) {
            /* Create a copy of the original
            array to simulate flipping a zero to 1*/
            int[] modifiedArray = nums.clone();
            modifiedArray[flipIndex] = 1;

            /* Variables to store the current streak and
           the maximum streak for this  iteration*/
            int currentConsecutiveOnes = 0;
            int maxCurrentStreak = 0;

            /* Traverse the modified array and calculate
            the maximum consecutive 1's */
            for (int num : modifiedArray) {
                if (num == 1) {
                    currentConsecutiveOnes++;
                    maxCurrentStreak = Math.max(maxCurrentStreak, currentConsecutiveOnes);
                } else {
                    currentConsecutiveOnes = 0;
                }
            }

            // Update the global maximum if the current streak is greater
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, maxCurrentStreak);
        }
        return maxConsecutiveOnes;
    }
}