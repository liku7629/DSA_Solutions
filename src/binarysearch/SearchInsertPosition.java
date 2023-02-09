package binarysearch;

// https://leetcode.com/problems/search-insert-position/description/
public class SearchInsertPosition {

}

// [2,3,5,6] target=5
// if mid element == target return mid

// [2,3,5,6] target=1
// if target is less than nums[0] then
// start will be at 0 and end will move to left till -1
// in the end start <= end will be false and we will return start

// [2,3,5,6] target=7
// Like above end will at nums.length - 1 and start will move to right
// when start will go to nums.length start <= end will be false and we will return start
class SearchInsertPosition_Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}