package arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {

    }
}

class SubArraySumEqualsK_BruteForce_Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int currSum = nums[i];

            if (currSum == k) {
                count++;
            }

            for (int j = i + 1; j < nums.length; j++) {
                currSum += nums[j];

                if (currSum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

class SubArraySumEqualsK_Optimal_Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;

        Map<Integer, Integer> occuranceMap = new HashMap<>();
        occuranceMap.put(0, 1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (occuranceMap.containsKey(sum - k)) {
                res += occuranceMap.get(sum - k);
            }

            occuranceMap.put(sum, occuranceMap.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}