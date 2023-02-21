package arrays;

public class SortArrayByParity {

}

//BruteForce solution
//  Time Complexity: O(n)
//  Space Complexity: O(n)
// take two pointer iterate throught the input array and filter evens and odds
 class SortArrayByParity_BruteForce_Solution {

     public int[] sortArrayByParity(int[] nums) {
         int[] result = new int[nums.length];

         int oddPtr = nums.length - 1;
         int evenPtr = 0;

         for (int i = 0; i < nums.length; i++) {
             if (nums[i] % 2 == 0) {
                 result[evenPtr++] = nums[i];
             } else {
                 result[oddPtr--] = nums[i];
             }
         }

         return result;
     }
 }


//  Optimal solution
//  Time Complexity: O(n)
//  Space Complexity: O(1)

// take two pointers oddPtr and evenPtr
// if evenPtr is pointing to even the evenPtr++
// else if (evenPtr is odd and oddPtr is even) then swap
// else oddPtr-- because oddPtr is pointing to odd
class SortArrayByParity_Optimized_Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenPtr = 0, oddPtr = nums.length - 1;

        while (evenPtr < oddPtr) {
            if (nums[evenPtr] % 2 == 0) {
                evenPtr++;
            } else if (nums[evenPtr] % 2 != 0 && nums[oddPtr] % 2 == 0) {
                int temp = nums[oddPtr];
                nums[oddPtr] = nums[evenPtr];
                nums[evenPtr] = temp;
                evenPtr++;
                oddPtr--;
            } else {
                oddPtr--;
            }
        }

        return nums;
    }
}
