package string;

import java.util.Arrays;

public class LongestWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("aabcdabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Solution().lengthOfLongestSubstring("tmmzuxt"));
    }


}

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() <=1) {
            return s.length();
        }

        int[] freq = new int[256];
        Arrays.fill(freq, -1);

        int longestLength = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, freq[s.charAt(i)] + 1);
            longestLength = Math.max(longestLength, i - start + 1);
            freq[s.charAt(i)] = i;
        }

        return longestLength;
    }
}