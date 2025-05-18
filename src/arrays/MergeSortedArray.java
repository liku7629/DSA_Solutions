package arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        new MergeSortedArray_Solution_For().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{1};
        nums2 = new int[]{};

        new MergeSortedArray_Solution().merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{0};
        nums2 = new int[]{1};

        new MergeSortedArray_Solution().merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}

class MergeSortedArray_Solution_For {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--; n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[i] = nums1[m--];
                } else {
                    nums1[i] = nums2[n--];
                }
            } else if (m <= 0 && n >= 0) {
                nums1[i] = nums2[n--];
            }

        }
    }
}


class MergeSortedArray_Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--; n--;

        int tail = nums1.length;

        while(m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[--tail] = nums1[m];
                m--;
            } else {
                nums1[--tail] = nums2[n];
                n--;
            }
        }

        while(n >= 0) {
            nums1[--tail] = nums2[n];
            n--;
        }
    }
}