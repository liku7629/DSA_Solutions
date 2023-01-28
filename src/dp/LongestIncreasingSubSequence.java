package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 6, 2, 3, 10};
        int[] arr2 = {7,7,7,7,7,7,7};
        int[] arr3 = {0,1,0,3,2,3};
        int[] arr4 = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
//        int i = new Solution().lengthOfLIS(arr4);
//        System.out.println("result=" + i);
        System.out.println(8 % 4);
    }
}

class LongestIncreasingSubSequence_Solution_BruteForce {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }

        int longest = 0;

        for (int curr : res) {
            longest = Math.max(longest, curr);
        }

        return longest;
    }
}

class LongestIncreasingSubSequence_Solution_SubOptimal {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            System.out.println("Sub=" + sub + " i=" + i);
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the first element in sub that is greater than or equal to num
                System.out.println("Before Sub=" + sub + " i=" + i);
                int j = 0;
                while (num > sub.get(j)) {
                    j += 1;
                }

                sub.set(j, num);
                System.out.println("After Sub=" + sub + " i=" + i);
            }
        }

        return sub.size();
    }
}

class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int idx = binarySearch(sub, num);
                sub.set(idx, num);
            }
            System.out.println("Sub=" + sub + " i=" + i);
        }

        return sub.size();
    }

    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
