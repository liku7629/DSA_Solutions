package string;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isValidAnagram("anagram", "nagaran"));
    }

    public static boolean isValidAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++count);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = map.get(c);

            if (count == null || count == 0) {
                return false;
            } else {
                map.put(c, --count);
            }
        }

        return true;
    }

    public static int leftMostRepeatingCharacter(String str) {
        int[] countArr = new int[256];

        int res = Integer.MAX_VALUE;
        Arrays.fill(countArr, -1);
        for (int i = 0; i < str.length(); i++) {
            int index = countArr[str.charAt(i)];

            if (index == -1) {
                countArr[str.charAt(i)] = i;
            } else {
                res = Math.min(res, i);
            }

        }

        return res;
    }
}
