package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        System.out.println(calculateCommissionWithGst(10000));
    }

    public static double calculateCommissionWithGst(double amount) {
        double commission = (amount / 100) * 0.2;
        double gst = (commission / 100) * 18;
        return commission + gst;
    }
}

class IntersectionofTwoArraysII_Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();

        for (int n : nums2) {
            Integer count = map.getOrDefault(n, 0);
            if (count > 0) {
                resultList.add(n);
                map.put(n, --count);
            }
        }

        int[] result = resultList.stream().mapToInt(i -> i).toArray();

        return result;
    }
}
