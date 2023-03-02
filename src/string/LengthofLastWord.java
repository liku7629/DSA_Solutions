package string;

// https://leetcode.com/problems/length-of-last-word/description/
public class LengthofLastWord {

}

class LengthofLastWord_Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");

        if (words.length == 0) {
            return words.length;
        }

        return words[words.length - 1].length();
    }
}