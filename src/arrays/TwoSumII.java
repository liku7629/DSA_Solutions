package arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumII {

}

// Since the input array is sorted
// We will take two pointers high, low
// If curr sum is > target we will decrement high
// else we will increment low
class TwoSumII_Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];

            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }

        return new int[]{};
    }
}
