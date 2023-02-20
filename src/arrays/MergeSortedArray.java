package arrays;

public class MergeSortedArray {

}

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int j = 0;

//         for (int i = m; i < m + n; i++ ) {
//             nums1[i] = nums2[j];
//             j++;
//         }

//         Arrays.sort(nums1);
//     }
// }


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