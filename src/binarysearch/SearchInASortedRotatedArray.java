package binarysearch;

public class SearchInASortedRotatedArray {

    public static void main(String[] args) {
        int min = new SearchInASortedRotatedArray().findMin(new int[]{1, 2});
        System.out.println(min);
    }

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