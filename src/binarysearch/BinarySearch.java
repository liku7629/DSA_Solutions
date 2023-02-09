package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        new BinarySearch_Solution()
                .search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);

        System.out.println("\n");

        new BinarySearch_Solution()
                .search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, -1);
    }
}

class BinarySearch_Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            System.out.println("start=" + start + " end=" + end + " mid=" + mid);

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (!(start <= end))
                System.out.println("start=" + start + " end=" + end + " mid=" + mid);
        }

        return -1;
    }
}
