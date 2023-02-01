package arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/single-number/description/
public class SingleNumber {
    public static void main(String[] args) {

    }
}

//Create a freq map and return the element with count 1
class SingleNumber_Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++count);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return nums[0];
    }
}
