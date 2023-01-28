package string;

import java.util.*;

public class CheckAnagram {
    public static void main(String[] args) {
        System.out.println(new CheckAnagram().findAnagrams("abab", "ab"));
        System.out.println(new CheckAnagram().findAnagrams("geeksforgeeks", "frog"));
        System.out.println(new CheckAnagram().findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

    public List<Integer> findAnagrams(String s,String p){
        ArrayList<Integer> anagrams = new ArrayList<>();

        if (p.length() > s.length()) {
            return anagrams;
        }

        int[] txtFreq = freq(s, p.length());
        int[] patFreq = freq(p, p.length());

        if (Arrays.equals(txtFreq, patFreq)) {
            anagrams.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            txtFreq[s.charAt(i - p.length()) - 'a']--;
            txtFreq[s.charAt(i) - 'a']++;

            if (Arrays.equals(txtFreq, patFreq)) {
                anagrams.add(i - p.length() + 1);
            }
        }

        return anagrams;
    }

    public static int[] freq(String s, int length) {
        int[] arr = new int[26];

        for (int i = 0; i < length; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        return arr;
    }
}
