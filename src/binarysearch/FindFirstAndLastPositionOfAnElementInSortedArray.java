package binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfAnElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfAnElementInSortedArray_Solution().searchRange(new int[] {5,7,7,8,8,10}, 8)));
    }
}

class FindFirstAndLastPositionOfAnElementInSortedArray_Solution {
    public int[] searchRange(int[] nums, int target) {
        System.out.println(findFirst(nums, target));

        return new int[] {findFirst(nums, target), findLast(nums, target)};
    }

    public int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        int firstIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                firstIndex = mid;
                end = mid - 1;
                continue;
            }

            if (target >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return firstIndex;
    }

     public int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        int lastIndex = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                lastIndex = mid;
                start = mid + 1;
                continue;
            }

            if (target >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return lastIndex;
     }
}
