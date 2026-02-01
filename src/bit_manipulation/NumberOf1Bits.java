package bit_manipulation;

// https://leetcode.com/problems/number-of-1-bits/description/
public class NumberOf1Bits {
    public static void main(String[] args) {
        new NumberOf1Bits_Solution().hammingWeight(11);
    }
}

class NumberOf1Bits_Solution {
    public int hammingWeight(int n) {
        int count = 0;

        System.out.println("n=" + n + " Binary=" + Integer.toBinaryString(n));

        while (n != 0) {
            n &= (n - 1);
            System.out.println("n=" + n + " Binary=" + Integer.toBinaryString(n));
            count++;
        }

        return count;
    }
}
