package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {

}

// Add all the elements for nums1 to set
// and check if nums2 element intersect
class IntersectionofTwoArrays_Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }

        Set<Integer> resultSet = new HashSet<>();

        for (int n : nums2) {
            if (set.contains(n)) {
                resultSet.add(n);
            }
        }

        int[] result = resultSet.stream().mapToInt(i -> i).toArray();
        return result;
    }
}