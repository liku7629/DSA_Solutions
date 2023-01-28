package dp;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain {
    public static void main(String[] args) {
        new LongestStringChain_Solution().isPredecessor("ae", "pcxbcf");
    }
}

class LongestStringChain_Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length())
        );

        // System.out.println(Arrays.toString(words));

        //optmization over striver solution
        //if current string length is 5 then we should start from
        //string index whose length is 4 not with string length 1
        //Here we will store HashMap String length as Key and start index with that length as value
        //input=[xb, xbc, cxbc, pcxbc, pcxbcf]
        //map={2=0, 3=1, 4=2, 5=3, 6=4}

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Integer index = map.get(words[i].length());

            if (index == null) {
                map.put(words[i].length(), i);
            }
        } //optimization till here

        System.out.println(map);

        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);

        int longestChain = 0;
        for (int current = 0; current < words.length; current++) {
            Integer start = map.get(words[current].length() - 1);

            if (start == null) {
                // System.out.println("Start is null");
                start = 0;
            }

            // System.out.println("curr=" + words[current] + " start=" + start);

            for (int prev = start; prev < current; prev++) {
                if (isPredecessor(words[prev], words[current])) {
                    dp[current] = Math.max(dp[prev] + 1, dp[current]);
                }
                // System.out.println(" current=" + current + "=" + words[current] +"  " + prev + "= prev=" + words[prev] + "  isPred=" + isPred);
                // System.out.println(Arrays.toString(dp));
            }

            if (dp[current] > longestChain) {
                longestChain = dp[current];
            }
        }

        return longestChain;
    }


    public boolean isPredecessor(String s1, String s2) {
        if (s1.length() + 1 != s2.length()) return false;
        int s1Ptr = 0, s2Ptr = 0;

        while (s2Ptr < s2.length()) {
            if (s1Ptr < s1.length() &&
                    s1.charAt(s1Ptr) == s2.charAt(s2Ptr)) {
                s1Ptr++;
                s2Ptr++;
            } else {
                s2Ptr++;
            }
        }

        return s1.length() == s1Ptr && s2.length() == s2Ptr;
    }
}