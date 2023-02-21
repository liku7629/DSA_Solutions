package arrays;

import java.util.Arrays;

public class SumofAllOddLengthSubarrays {

}

 class SumofAllOddLengthSubarrays_BruteForce_Solution {
     public int sumOddLengthSubarrays(int[] arr) {
         int[] temp = new int[arr.length];
         int sum = 0;

         for (int i = 0; i < arr.length; i++) {
             sum += arr[i];
             temp[i] = sum;
         }

         System.out.println(Arrays.toString(temp));

         int sumOfAll = temp[temp.length - 1];

         for (int i = 0; i < arr.length; i++) {
             for (int j = i; j < arr.length; j++) {
                 if ((j - i) % 2 == 0) {
                     if (i != j) {
                         sumOfAll += temp[j];

                         if (i > 0) {
                             sumOfAll = sumOfAll - temp[i - 1];
                         }
                     }
                 }
             }
         }

         return sumOfAll;
     }
 }

class SumofAllOddLengthSubarrays_Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;

        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = n - i;
            int noOfSubArrays = left * right;
            int appeared = noOfSubArrays % 2 == 0 ? noOfSubArrays / 2 : (noOfSubArrays / 2) + 1;
            totalSum += appeared * arr[i];
        }

        return totalSum;
    }
}
