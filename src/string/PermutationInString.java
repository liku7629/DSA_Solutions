package string;

import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] patFreq = getFrequency(s1);
        int[] txtFreq = getFrequency(s2.substring(0, s1.length()));

        if (Arrays.equals(patFreq, txtFreq)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            txtFreq[s2.charAt(i - s1.length()) - 'a']--;
            txtFreq[s2.charAt(i) - 'a']++;

            if (Arrays.equals(txtFreq, patFreq)) return true;
        }

        return false;
    }

    public static int[] getFrequency(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        return arr;
    }
}
