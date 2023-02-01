package arrays;

public class RearrangeArrayElementsbySign {

}

class RearrangeArrayElementsbySign_Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];

        int positive = 0, negative = 1;

        for (int element : nums) {
            if (element >= 0) {
                result[positive] = element;
                positive += 2;
            } else {
                result[negative] = element;
                negative += 2;
            }
        }

        return result;
    }
}
