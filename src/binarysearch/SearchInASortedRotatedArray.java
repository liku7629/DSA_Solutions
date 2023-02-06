package binarysearch;

public class SearchInASortedRotatedArray {

    public static void main(String[] args) {
        int result = new SearchInASortedRotatedArray_Solution()
                .search(new int[]{7, 6, 5, 4, 3, 0, 1, 2}, 1);
        System.out.println(result);
    }
}

class SearchInASortedRotatedArray_Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}