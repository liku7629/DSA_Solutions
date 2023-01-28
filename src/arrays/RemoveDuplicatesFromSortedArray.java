package arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
//soln: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27987/Short-and-Simple-Java-solution-(easy-to-understand)
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
//        System.out.println(removeDuplicates(new int[] {1,1, 2, 2, 2, 3, 4, 5, 5}));
//        System.out.println(removeDuplicates1(new int[] {1,1, 2, 2, 2, 3, 4, 5, 5}));
        System.out.println(removeDuplicates2(new int[] {1, 1, 1,1, 2, 2, 2, 3, 4, 5, 5, 5}));
        System.out.println(removeDuplicates2(new int[] {1, 2, 3}));
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
    public static int removeDuplicates(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[res] < arr[i]) {
                res++;
                arr[res] = arr[i];
            }
        }

        return res;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
    public static int removeDuplicates1(int[] nums) {
        int i = 1;
        for(int n : nums)
            if(n > nums[i - 1])
                nums[i++] = n;

        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
        System.out.println();

        return i;
    }

    //this is like sliding window fixed size 2, no more than two elements can be there in an window
    public int removeDuplicates2Shortcut(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    // take two pointers one will be the end pointer and another will be the result
    // if (arr[res - 2] > arr[end]) then update the value at the end
    public static int removeDuplicates2(int[] nums) {
        int i = 2;

        //if arr size is less than 2 then j < 2 will be true and it will handle that as well
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] > nums[i - 2])
                nums[i++] = nums[j];
        }

        printArray(nums, i);
        return i;
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
