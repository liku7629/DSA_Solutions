package arrays;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {

}

// Bruteforce Solution
// Run two loops if i and j dit not match add it to product
class ProductOfArrayExceptSelf_Bruteforce_Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;

            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }
}

// explanation: https://www.youtube.com/watch?v=gREVHiZjXeQ&ab_channel=Techdose

// class Solution {

//     public int[] productExceptSelf(int[] nums) {

//         int[] result = new int[nums.length];

//         //Initialize the result array with 1
//         Arrays.fill(result, 1);


//         // We will take two loops and iterate and check if i and j match
//         // if they match then we will skip the that
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = 0; j < nums.length; j++) {

//                 // here we will skip the current number
//                 if (i == j) {
//                     continue;
//                 }

//                 result[i] = result[i] * nums[j];
//             }
//         }

//         return result;
//     }
// }