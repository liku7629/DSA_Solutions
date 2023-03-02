package string;

// https://leetcode.com/problems/reverse-only-letters/description/
public class ReverseOnlyLetters {

}

//Time: O(n)
//Space:O(1)

// if start is not char or end is not char skip it else swap start and end
class ReverseOnlyLetters_Solution {

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();

        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetter(chars[start])) {
                start++;
            } else if (!Character.isLetter(chars[end])) {
                end--;
            } else {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }

        return new String(chars);
    }
}