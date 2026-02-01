package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

class IntersectionofTwoArrays_Stream_Api_Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toSet());
        return Arrays.stream(nums2)
                .filter(n -> set.contains(n))
                .distinct()
                .toArray();
    }
}