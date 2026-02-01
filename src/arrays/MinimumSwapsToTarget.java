package arrays;

import java.util.*;

public class MinimumSwapsToTarget {
    public static int minSwapsToTarget(int[] source, int[] target) {
        int n = source.length;
        Map<Integer, Integer> targetIndexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            targetIndexMap.put(target[i], i);
        }

        int[] indexArray = new int[n];
        for (int i = 0; i < n; i++) {
            indexArray[i] = targetIndexMap.get(source[i]);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexArray[i] == i) continue;

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indexArray[j];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 3};
        System.out.println(minSwapsToTarget(source, target));  // Output: 2
    }
}

