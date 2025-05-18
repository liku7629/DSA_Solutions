package bit_manipulation;

// https://leetcode.com/problems/single-number/description/
public class SingleNumber {
    public static void main(String[] args) {
//        System.out.println(new SingleNumber_Solution().singleNumber(new int[] {4,1,2,1,2}));
        System.out.println(Integer.toBinaryString(4 ^ 3 ^ 3 ^ 4 ^ 5));
    }
}

// -> A XOR operation will always leads zero with duplicate elements
// Like 4 ^ 4 = 0 or 4 ^ 3 ^ 3 ^ 4
class SingleNumber_Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}