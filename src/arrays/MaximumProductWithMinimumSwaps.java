package arrays;

import java.util.*;

public class MaximumProductWithMinimumSwaps {

    public static void main(String[] args) {
        // Example usage

        int[] arr = {3, 5, 1, 2, 4, 6};

        long maxProduct = 1;
        for (int i = 0; i < arr.length; i += 2) {
            maxProduct *= (long)(arr[i] + arr[i + 1]);
        }
        System.out.println("Maximum Product Before swap: " + maxProduct);

        Result result = maximizeProduct(arr);
        System.out.println("Maximum Product: " + result.product);
        System.out.println("Minimum Swaps: " + result.swaps);
    }

    /**
     * Represents the result containing the maximum product and minimum swaps required
     */
    static class Result {
        long product;
        int swaps;

        public Result(long product, int swaps) {
            this.product = product;
            this.swaps = swaps;
        }
    }

    /**
     * Pair class to keep track of elements and their original indices
     */
    static class Pair {
        int value;
        int originalIndex;

        public Pair(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }
    }

    /**
     * Main function to maximize the product with minimum swaps
     * @param arr The input array
     * @return Result containing maximum product and minimum swaps
     */
    public static Result maximizeProduct(int[] arr) {
        int n = arr.length;

        // Create a copy of the original array to calculate swaps
        int[] original = Arrays.copyOf(arr, n);

        // Create pairs of (value, originalIndex) to track original positions
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        // Sort pairs by value
        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair.value));

        // Create the optimal arrangement (smallest, largest, second smallest, second largest, etc.)
        int[] targetArr = new int[n];
        int[] targetPos = new int[n];

        for (int i = 0; i < n / 2; i++) {
            // Place smallest elements at even positions (0, 2, 4...)
            targetArr[2 * i] = pairs[i].value;
            targetPos[pairs[i].originalIndex] = 2 * i;

            // Place largest elements at odd positions (1, 3, 5...)
            targetArr[2 * i + 1] = pairs[n - 1 - i].value;
            targetPos[pairs[n - 1 - i].originalIndex] = 2 * i + 1;
        }

        // Calculate the maximum product
        long maxProduct = 1;
        for (int i = 0; i < n; i += 2) {
            maxProduct *= (long)(targetArr[i] + targetArr[i + 1]);
        }

        // Calculate minimum swaps using cycle finding algorithm
        int swaps = calculateMinSwaps(original, targetPos);

        return new Result(maxProduct, swaps);
    }

    /**
     * Calculate minimum swaps required to transform the array
     * into the target arrangement using cycle finding algorithm
     * @param arr Original array
     * @param targetPos Target position for each element
     * @return Minimum number of swaps
     */
    private static int calculateMinSwaps(int[] arr, int[] targetPos) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // Skip already visited positions or elements already in correct position
            if (visited[i] || targetPos[i] == i) {
                continue;
            }

            // Start of a new cycle
            int cycleSize = 0;
            int j = i;

            // Follow the cycle
            while (!visited[j]) {
                visited[j] = true;
                j = targetPos[j];
                cycleSize++;
            }

            // For a cycle of size K, we need K-1 swaps
            swaps += (cycleSize - 1);
        }

        return swaps;
    }

}