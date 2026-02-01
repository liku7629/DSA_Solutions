package sliding_window;

public class Count_Subarrays_With_Fixed_Bounds {
    public static void main(String[] args) {
//        int[] test = new int[] {7,1,3,5,2,5};
//        long l = Count_Subarrays_With_Fixed_Bounds_Optimal.countSubarrays(test, 1, 5);

        int[] test = new int[] {1,1,1,1};
        long l = Count_Subarrays_With_Fixed_Bounds_Optimal.countSubarrays(test, 1, 1);
    }
}

class Count_Subarrays_With_Fixed_Bounds_Optimal {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;

        int lastMin = -1;   // last index where nums[i] == minK
        int lastMax = -1;   // last index where nums[i] == maxK
        int lastBad = -1;   // last index where nums[i] < minK or nums[i] > maxK

        for (int i = 0; i < nums.length; i++) {

            // If current element is invalid, reset boundary
            if (nums[i] < minK || nums[i] > maxK) {
                lastBad = i;
            }

            // Update last seen positions
            if (nums[i] == minK) {
                lastMin = i;
            }
            if (nums[i] == maxK) {
                lastMax = i;
            }

            // Count valid subarrays ending at index i
            int validStart = Math.min(lastMin, lastMax);
            if (validStart > lastBad) {
                count += (validStart - lastBad);
            }
        }

        return count;
    }
}