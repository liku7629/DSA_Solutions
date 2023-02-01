package arrays;

import java.util.Arrays;

public class SortColors {

}

class SortColors_BruteForce_Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

class SortColors_Optimal_Solution {
    public void sortColors(int[] nums) {
        int totalZero = 0, totalOne = 0, totalTwo = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                totalZero++;

            if (nums[i] == 1)
                totalOne++;

            if (nums[i] == 2)
                totalTwo++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (totalZero >= 1){
                nums[i] = 0;
                totalZero--;
            } else if (totalOne >= 1){
                nums[i] = 1;
                totalOne--;
            } else
                nums[i] = 2;
        }
    }
}
