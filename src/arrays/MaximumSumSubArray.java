package arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        System.out.println(new MaximumSumSubArray().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(maxSubArray(new int[] {1}));
//        System.out.println(maxSubArray(new int[] {5,4,-1,7,8}));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];

        int currSum = nums[0];

        //First we will initialize curr

        //for each element it will check if the current sum is > nums[i]
        //if it is greater then it will update the current sum and check
        //if currSum is greater than max sum if yes then it will update maxSum
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    public int maxSubArrayBruteForce(int[] nums) {
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currSum = nums[i];
            maxSum = Math.max(currSum, maxSum);

            for (int j = i + 1; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(currSum, maxSum);
            }
        }

        return maxSum;
    }
}


