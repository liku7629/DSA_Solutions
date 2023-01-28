package arrays;

import java.util.Arrays;

public class RotateArray {
    
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println("i=" + i + " "+ ((i + 3) % 7));
        }    
    }
    
    public void rotate(int[] nums, int k) {
        
    }
}

 class RotateArray_SolutBruteon {
     public void rotate(int[] nums, int k) {
         int[] temp = new int[nums.length];

         for (int i = 0; i < nums.length; i++) {
             temp[(i + k) % nums.length] = nums[i];
             System.out.println(Arrays.toString(temp) + " nums[i]=" + nums[(i + k) % nums.length]);
         }

         for (int i = 0; i < nums.length; i++) {
             nums[i] = temp[i];
         }
     }
 }