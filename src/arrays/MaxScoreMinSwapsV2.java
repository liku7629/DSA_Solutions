package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxScoreMinSwapsV2 {

    /**
     * Calculates the maximum possible product by pairing elements such that
     * the sum of each pair is maximized, and returns the minimum number of swaps needed.
     *
     * @param originalArray The input array of integers (length n, even)
     * @return An array of two elements: [maximumProduct, minimumSwaps]
     */
    public static long[] getMaxScoreAndMinSwaps(int[] originalArray) {
        int length = originalArray.length;

        // Make a copy of the original array for swap counting
        int[] workingArray = Arrays.copyOf(originalArray, length);

        // Sort the array to pair maximum with minimum values
        Arrays.sort(workingArray);

        // Create optimal arrangement: pair smallest with largest
        int[] targetArrangement = new int[length];
        for (int i = 0; i < length / 2; i++) {
            // Place smallest elements at even indices (0, 2, 4...)
            targetArrangement[2 * i] = workingArray[i];
            // Place largest elements at odd indices (1, 3, 5...)
            targetArrangement[2 * i + 1] = workingArray[length - 1 - i];
        }

        // Calculate the maximum product by multiplying each (pair sum)
        long maximumProduct = 1L;
        final long MODULO = 1_000_000_007L; // To avoid overflow

        for (int i = 0; i < length; i += 2) {
            maximumProduct = (maximumProduct * (targetArrangement[i] + targetArrangement[i + 1])) % MODULO;
        }

        // Map each value to a queue of its positions in the original array for efficient look-up
        Map<Integer, Queue<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            valueToIndices.computeIfAbsent(originalArray[i], k -> new LinkedList<>()).add(i);
        }

        // Prepare visited marker
        boolean[] visited = new boolean[length];
        int minimumSwaps = 0;

        // Count the minimum number of swaps using cycle decomposition
        for (int i = 0; i < length; ++i) {
            if (visited[i] || originalArray[i] == targetArrangement[i]) continue;

            int cycleLength = 0;
            int currentIndex = i;

            while (!visited[currentIndex]) {
                visited[currentIndex] = true;
                int targetValue = targetArrangement[currentIndex];

                // Get the next position from the map and remove it from the queue
                Queue<Integer> positions = valueToIndices.get(targetValue);
                Integer nextIndex = null;

                // Find the first unvisited position
                while (!positions.isEmpty()) {
                    nextIndex = positions.peek();
                    if (!visited[nextIndex]) break;
                    positions.poll(); // Remove visited positions
                }

                if (nextIndex == null || visited[nextIndex]) break;

                positions.poll(); // Remove the position we're using
                currentIndex = nextIndex;
                cycleLength++;
            }

            if (cycleLength > 0) {
                minimumSwaps += (cycleLength - 1);
            }
        }

        return new long[] { maximumProduct, minimumSwaps };
    }

    // Example usage and test
    public static void main(String[] args) {
        int[] inputArray = {1, 3, 2, 4};
        long[] result = getMaxScoreAndMinSwaps(inputArray);
        System.out.println("Maximum Product: " + result[0]);
        System.out.println("Minimum Swaps: " + result[1]);

        // Verify the result with manual calculation
        int[] sorted = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(sorted);
        int[] optimal = new int[inputArray.length];
        for (int i = 0; i < inputArray.length / 2; i++) {
            optimal[2*i] = sorted[i];
            optimal[2*i+1] = sorted[inputArray.length-1-i];
        }

        long product = 1;
        for (int i = 0; i < inputArray.length; i += 2) {
            product *= (optimal[i] + optimal[i+1]);
        }

        System.out.println("Expected Maximum Product: " + product);
        System.out.println("Optimal Arrangement: " + Arrays.toString(optimal));
    }
}