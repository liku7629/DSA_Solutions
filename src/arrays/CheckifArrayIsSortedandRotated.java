package arrays;

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
public class CheckifArrayIsSortedandRotated {

}

class CheckifArrayIsSortedandRotated_Solution {
    // if the array is rotated the then must be pivot
    // in the pivot the left element > right element
    // if pivot count is 1 then the array is rotated
    // if 0 then not rotated
    // if > 1 then the array is not sorted

    // (i + 1) % nums.length to satisfy this test case: [2,1,3,4]
    // Here 4 > 2 and 2 > 1 two pivots
    // But without % length it will return true

    public boolean check(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >  nums[(i + 1) % nums.length]) {
                count++;
            }
        }

        return count <= 1;
    }
}
