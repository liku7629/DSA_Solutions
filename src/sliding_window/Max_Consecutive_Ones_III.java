package sliding_window;

public class Max_Consecutive_Ones_III {
    public static void main(String[] args) {
        Max_Consecutive_Ones_III_BruteForce_Solution.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2);
    }
}

class Max_Consecutive_Ones_III_BruteForce_Solution {
    public static int longestOnes(int[] nums, int k) {
        int maxOneCount = 0, currOneCount = 0, zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            currOneCount = 0;
            zeroCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) {
                    currOneCount++;
                } else if (nums[j] == 0 && zeroCount < k) {
                    zeroCount++;
                    currOneCount++;
                } else if (zeroCount == k && nums[j] == 0) {
                    break;
                }

                maxOneCount = Math.max(maxOneCount, currOneCount);
            }
        }

        return maxOneCount;
    }
}

// Whenever the window will have more than k zero we will trim from the left
class Max_Consecutive_Ones_III_Optimal_Solution {
    public int longestOnes(int[] nums, int k) {
        int maxOneCount = 0, zeroCount = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            while(zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maxOneCount = Math.max(maxOneCount, i - left + 1);
        }

        return maxOneCount;
    }
}
