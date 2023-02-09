package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new SlidingWindowMaximum_Optimal_Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }

}

//Time Limit Exceed Solution
// Iterate and find max of every window

// Time Complexity: O(N * K)
// Space Complxtiy: O(1) // If result array space is ignored
class SlidingWindowMaximum_BruteForce_Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
}


// Nearest Greator to Left pattern
// Here we will use a deque and compute nearest greator to left
// for every element
// if there is any smaller to left element exist in the deque
// we will remove these elements

// Time Complexity: O(N)  since each element is processed exactly twice - it's index added and then removed from the deque.
// Space complexity : O(N), since O(N−k+1) is used for an output array and O(k) for a deque.
// Space complexity : O(k) for a deque. If output array is ignored
class SlidingWindowMaximum_Optimal_Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            // remove out of the window size k elements
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // remove smaller elements to the left of current item
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // add current item to deque
            deque.offer(i);

            // add result to deque
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}