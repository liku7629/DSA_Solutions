package string;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String tree = new SortCharactersByFrequency_Semi_Optimized_Solution().frequencySort("tree");
        System.out.println(tree);
    }

}

class SortCharactersByFrequency_BrutrForce_Solution {
    public String frequencySort(String s) {

        if (s == null || s.isEmpty()) return s;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);


        List<String> identicalStrings = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                identicalStrings.add(sb.toString());
                sb = new StringBuilder();
            }

            sb.append(chars[i]);
        }
        identicalStrings.add(sb.toString());

        Collections.sort(identicalStrings, (a, b) -> b.length() - a.length());

        StringBuilder res = new StringBuilder(s.length());

        identicalStrings.forEach(str -> {
            res.append(str);
        });

        return res.toString();
    }
}

class SortCharactersByFrequency_Semi_Optimized_Solution {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Character, Integer> entry = list.get(i);
            for (int j = 0; j < entry.getValue(); j++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}