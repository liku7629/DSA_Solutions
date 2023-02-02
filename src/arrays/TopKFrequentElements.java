package arrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

//https://leetcode.com/problems/top-k-frequent-elements
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] ints = new TopKFrequentElements_Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
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

// Interview Answer
// https://leetcode.com/problems/top-k-frequent-elements/solutions/646157/top-k-frequent-elements/
class TopKFrequentElements_Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2)); // use this comparetor to sort using freq

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
