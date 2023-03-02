package string;

// https://leetcode.com/problems/is-subsequence/description/
public class IsSubsequence {

}

// Time : O(n)
// Space: O(1)

// Use two pointers one point to start of s and one to start of t
// if both match increment j. if j reaches s.length() the s is a subsequence of t
class IsSubsequence_Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;

        for (int i = 0; i < t.length(); i++) {
            if (j < s.length() && s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }

        return j == s.length();
    }
}