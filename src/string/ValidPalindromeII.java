package string;

// https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindromeII {

}

// Input: s = "aba"
// Output: true

//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.

// take two pointers and check for palindrome if goes till i < j return true
// if found a mismatch in between search with i + 1 to skip one char from left and
// j - 1 to skip one char from right
class ValidPalindromeII_Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i + 1, j) ||
                        validPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }

        return true;
    }

    public boolean validPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}


