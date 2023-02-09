package binarysearch;

public class SearchinRotatedSortedArrayII {

}

class SearchinRotatedSortedArrayII_Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        // trim leading duplicates like [1, 1, 1, 1, 1, 0, 1, 1]
        while (start < end && nums[start] == nums[start + 1])
            start++;

        // trim trailing duplicates like [1, 1, 0, 1, 1, 1, 1, 1]
        while (start < end && nums[end] == nums[end - 1])
            end--;

        // same as SearchInASortedRotatedArray 1
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return true;

            if ((nums[mid] <= nums[end])) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return false;
    }
}