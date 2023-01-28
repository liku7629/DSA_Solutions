package arrays;

public class MaximumProductSubArray {

    public static void main(String[] args) {
//        System.out.println(new MaximumSumSubArray().());
    }

    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currProduct = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                currProduct = Math.max(currProduct, currProduct * nums[j]);
                maxProduct = Math.max(currProduct, maxProduct);
            }
        }

        return maxProduct;
    }
}