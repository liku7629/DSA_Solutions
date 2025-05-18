package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public static void main(String[] args) {
        System.out.println(FindAllNumbersDisappearedinanArray_Optimal_Solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}

class FindAllNumbersDisappearedinanArray_Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int n : nums) {
            set.add(n);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}

class FindAllNumbersDisappearedinanArray_Optimal_Solution {

    // https://www.youtube.com/watch?v=8i-f24YFWC4
    // Optimal Approach
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;


            // We only care whether a number has appeared at least once. Once it’s negative, that fact is recorded. Further visits to that same index are irrelevant, so we skip them.
            if (nums[idx] > 0)
                nums[idx] *= -1;
        }

        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                results.add(i + 1);
            }
        }

        return results;
    }
}