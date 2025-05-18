package heap;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {
}



class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequency.entrySet());
        
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // Sort by frequency (descending)
            }
            return a.getKey().compareTo(b.getKey()); // Sort lexicographically (ascending)
        });
        return list.subList(0, k - 1)
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}