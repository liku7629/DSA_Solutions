package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

}

class FindAllNumbersDisappearedinanArray_Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
