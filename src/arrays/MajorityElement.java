package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

}

 class MajorityElement_Bruteforce_Solution {
     public int majorityElement(int[] nums) {
         Arrays.sort(nums);
         return nums[nums.length / 2];
     }
 }

//
class MajorityElement_HashMap_Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int majorityCount = 0;
        int majorityElement = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majorityCount && entry.getValue() > n / 2) {
                majorityCount = entry.getValue();
                majorityElement = entry.getKey();
            }
        }

        return majorityElement;
    }
}

// single for loop solution
class MajorityElement_Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer count = map.getOrDefault(nums[i], 0) + 1;

            if (count > (n / 2)) {
                return nums[i];
            }

            map.put(nums[i], count);
        }

        return -1;
    }
}