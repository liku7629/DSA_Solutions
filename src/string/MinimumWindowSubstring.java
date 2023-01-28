package string;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String minWindow = new MinimumWindowSubstring_Solution().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(minWindow);
    }
}

class MinimumWindowSubstring_Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int low = 0, high = 0, head = 0;
        int count = 0, min = Integer.MAX_VALUE;

        while (high < s.length()) {
            char c = s.charAt(high++);
            if (map[c]-- > 0)
                count++;

            while (count == t.length()) {
                if (high - low < min) {
                    min = high - low;
                    head = low;
                }
                if (map[s.charAt(low++)]++ >= 0)
                    count--;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }
}