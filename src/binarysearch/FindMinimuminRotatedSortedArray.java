package binarysearch;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
//        int min = new FindMinimuminRotatedSortedArray_Solution().findMin(new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7});
//        System.out.println("result=" + min);
//        new FindMinimuminRotatedSortedArray_Solution().findMin(new int[] {3, 4, 5, 6, 7, 8, 9, 1, 2});
        new FindMinimuminRotatedSortedArray_Solution().findMin(new int[] {5, 4, 3, 2, 1});
    }
}

//Ex: [8, 9, 1, 2, 3, 4, 5, 6, 7]

// if nums[start] > nums[mid] the min is on the left half
// else min is on the right half
class FindMinimuminRotatedSortedArray_Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0, end = nums.length - 1;

        if (nums[start] < nums[end]) {
            return nums[start];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            System.out.println("start=" + start + " end=" + end + " mid=" + mid);

            // here we not get IndexOutOfBoundException because at the start we are
            // check if (nums[start] < nums[end])
            // and minimum element will be at the end since the array is sorted in ascending order
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[start] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
