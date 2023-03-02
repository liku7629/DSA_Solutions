package string;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-palindrome/description/
public class LongestPalindrome {

}
//Input: s = "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

// Add all character to set and check for duplicate if found remove the element
// in this way we will find total no of pairs to form palindrome
// longestPalindrome = totalPairs - totalUniques + 1 (since one char can be present in the middle)
class LongestPalindrome_Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() == 0 ? s.length() : s.length() - set.size() + 1;
    }
}