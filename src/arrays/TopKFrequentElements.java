package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] ints = new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++count);
        }

        int[] res = new int[k];

        AtomicInteger i = new AtomicInteger(0);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        entries.stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .forEach(entry -> {
                    res[i.getAndIncrement()] = entry.getKey();
                });

        return res;
    }

}
