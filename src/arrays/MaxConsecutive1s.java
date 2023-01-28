package arrays;

public class MaxConsecutive1s {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currCount++;
            } else {
                count = Math.max(count, currCount);
                currCount = 0;
            }
        }
        count = Math.max(count, currCount);

        return count;
    }
}
