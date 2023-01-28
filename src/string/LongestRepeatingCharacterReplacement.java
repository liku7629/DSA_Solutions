package string;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        new LongestRepeatingCharacterReplacement_Solution().characterReplacement("AABABBA", 1);
    }


}

class LongestRepeatingCharacterReplacement_Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxLength = 0;
        int maxFreq = 0;

        int[] freqArr = new int[26];

        for (int end = 0; end < s.length(); end++) {
            maxFreq = Math.max(maxFreq, ++freqArr[s.charAt(end) - 'A']);

            int diff = end - start + 1 - maxFreq;

            if (diff > k) {
                --freqArr[s.charAt(start) - 'A'];
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
