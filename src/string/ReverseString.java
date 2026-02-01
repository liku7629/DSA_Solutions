package string;

// https://leetcode.com/problems/reverse-string/
public class ReverseString {

}

// In this solution we will take two pointers left and right
// Swap s[left] with s[right]
// At the end left will be greater or equal to the right and we will stop
// If the array is even left will be > right and in case of odd left == right
class ReverseString_Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left <= right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;

            left++; right--;
        }
    }
}
