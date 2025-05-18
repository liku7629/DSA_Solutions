package arrays;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(new RemoveElement_Solution()
                .removeElement(new int[] {3, 2, 2, 3}, 3));
    }
}

class RemoveElement_Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left++] = nums[i];
            }
        }

        return left;
    }
}