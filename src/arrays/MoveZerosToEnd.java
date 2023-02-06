package arrays;

public class MoveZerosToEnd {
}

//Here we will take two pointers  start* and end*
// Input [0,1,0,3,12]
// if end != 0 and start == 0
// then we will copy the element at end, set [end] = 0 and increment both
class MoveZerosToEnd_Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] != 0 && nums[start] == 0) {
                nums[start++] = nums[end];
                nums[end] = 0;
            }

            if (nums[start] != 0) {
                start++;
            }
        }
    }
}
