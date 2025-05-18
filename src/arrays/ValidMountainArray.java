package arrays;

//https://leetcode.com/problems/valid-mountain-array/
public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println(new ValidMountainArray_Solution().validMountainArray(new int[] {0,3,2,1}));
    }
}

// We will take two pointers approach to solve this question
// one pointer will be at the start and another will be at the end
// we will check if the left pointer is less than the next element
// if the right pointer is greater than the previous element
// if both the conditions are true then we will move the left pointer to the next element
// and the right pointer to the previous element
// if both the pointers are equal then we will return true
class ValidMountainArray_Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        if (n < 3) return false;

        int left = 0, right = n - 1;

        // **Notice we have take left < n - 2 instead of n - 1 and right > 1 instead of 0
        // to fix issues like [1, 2, 3, 4, 5] and [5, 4, 3, 2, 1]
        while (left < n - 2 && arr[left] < arr[left + 1]) left++;
        while (right > 1 && arr[right - 1] > arr[right]) right--;

        return left == right;
    }
}