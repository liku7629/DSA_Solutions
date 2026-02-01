package arrays;

import java.util.Arrays;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {

}

// Input: [1,2,0,1]
// sort the input= [0, 1, 1, 2]
// if the array contains duplicates then its a valid sequence.          //: confirm with intviewer
// else if (nums[i - 1] != nums[i]) checking for duplicate element like 1, 1 and also resetting the
// count to 1 and continue the iteration from current index
class LongestConsecutiveSequence_BruteForce_Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        int maxLength = 1;
        int currLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else if (nums[i - 1] != nums[i]) {
                currLength = 1;
            }
        }

        return maxLength;
    }
}