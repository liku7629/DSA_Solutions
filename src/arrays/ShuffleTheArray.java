package arrays;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        int[] result = new ShuffleTheArray_Optimized_Solution().shuffle(nums, n);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class ShuffleTheArray_Optimized_Solution {
    public int[] shuffle(int[] nums, int n) {
        // Iterate for each y_i element that needs to be placed.
        // 'i' here is the 0-indexed identifier for the pair (x_i, y_i).
        // In the target array:
        // x_i is conceptually at index 2*i.
        // y_i needs to be moved to index 2*i + 1.
        for (int i = 0; i < n; i++) {
            System.out.print("nums=" + Arrays.toString(nums) + " i=" + i + " n=" + n + "  ");
            // The target destination for the current y_i element.
            int targetPosForYi = 2 * i + 1;

            // The i-th element of the original y-block (y_i) is currently
            // located at index (n+i) in the potentially modified array.
            // This is because previous insertions/shifts for y_0, y_1, ..., y_{i-1}
            // only affected elements at indices less than (n+i).
            int currentPosOfYiValue = n + i; // This is the current index of y_0.
            int elementYi = nums[currentPosOfYiValue];

            System.out.println("targetPosForYi=" + targetPosForYi + " currentPosOfYiValue=" + currentPosOfYiValue + " elementYi=" + elementYi);

            // Shift elements to make space for y_i.
            // Elements from 'targetPosForYi' up to 'currentPosOfYiValue - 1'
            // need to move one step to the right.
            // We iterate backwards from the element just before where y_i was picked up,
            // down to the target insertion position.
            // 'j' is the index of the element being moved.
            // It moves from nums[j] to nums[j+1].
            for (int j = currentPosOfYiValue - 1; j >= targetPosForYi; j--) {
                nums[j + 1] = nums[j];
                System.out.println("j=" + j + " nums[j]=" + nums[j] + " nums[j+1]=" + nums[j + 1] + " nums=" + Arrays.toString(nums));
            }

            // Place the stored y_i element into its correct new position.
            nums[targetPosForYi] = elementYi;
        }
        return nums;
    }
}
