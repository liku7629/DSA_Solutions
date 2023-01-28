package string;

//https://leetcode.com/problems/find-the-difference/description/
public class FindTheDifference {
}

//Bruteforce approach
//sort the input char array and check for not matching char

//use frequence array to main frequence of s
//then decrement the frequence using string t
// check if there if any negative element the that is the answer
class FindTheDifference_Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];

        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) {
                freq[s.charAt(i) - 'a']++;
            }

            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == -1) {
                return (char) (97 + i);
            }
        }

        return ' ';
    }
}
