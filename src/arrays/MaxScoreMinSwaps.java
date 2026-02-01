package arrays;

import java.util.*;

public class MaxScoreMinSwaps {

    static class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static class Result {
        int maxScore;
        int minSwaps;
        List<Integer> bestPermutation;

        Result(int score, int swaps, List<Integer> perm) {
            this.maxScore = score;
            this.minSwaps = swaps;
            this.bestPermutation = perm;
        }
    }

    public static Result maxScoreWithMinSwaps(int[] arr) {
        int n = arr.length;
        if (n < 6) return new Result(0, 0, new ArrayList<>());

        // Step 1: Get top 6 largest elements with original indices
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int i = 0; i < n; i++) {
            pq.add(new Element(arr[i], i));
        }

        List<Element> top6 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            top6.add(pq.poll());
        }

        List<Integer> topValues = new ArrayList<>();
        for (Element e : top6) topValues.add(e.value);

        // Step 2: Try all permutations of top 6 elements
        List<Integer> bestPerm = new ArrayList<>();
        int bestScore = -1;

        List<List<Integer>> perms = generatePermutations(topValues);
        for (List<Integer> p : perms) {
            int score = (p.get(0) + p.get(1)) * (p.get(2) + p.get(3)) * (p.get(4) + p.get(5));
            if (score > bestScore) {
                bestScore = score;
                bestPerm = new ArrayList<>(p);
            }
        }

        // Step 3: Count swaps to bring top6 values to first 6 positions
        int[] tempArr = Arrays.copyOf(arr, n);
        boolean[] used = new boolean[n];
        int swaps = 0;
        int pos = 0;

        // Bring values to first 6 positions
        for (int val : bestPerm) {
            for (int j = pos; j < n; j++) {
                if (!used[j] && tempArr[j] == val) {
                    if (j != pos) {
                        int t = tempArr[j];
                        tempArr[j] = tempArr[pos];
                        tempArr[pos] = t;
                        swaps++;
                    }
                    used[j] = true;
                    break;
                }
            }
            pos++;
        }

        // Count swaps to rearrange first 6 to match bestPerm
        int[] firstSix = Arrays.copyOfRange(tempArr, 0, 6);
        for (int i = 0; i < 6; i++) {
            if (firstSix[i] != bestPerm.get(i)) {
                for (int j = i + 1; j < 6; j++) {
                    if (firstSix[j] == bestPerm.get(i)) {
                        int t = firstSix[j];
                        firstSix[j] = firstSix[i];
                        firstSix[i] = t;
                        swaps++;
                        break;
                    }
                }
            }
        }

        return new Result(bestScore, swaps, bestPerm);
    }

    private static List<List<Integer>> generatePermutations(List<Integer> nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, results);
        return results;
    }

    private static void permute(List<Integer> arr, int l, List<List<Integer>> results) {
        if (l == arr.size()) {
            results.add(new ArrayList<>(arr));
            return;
        }
        for (int i = l; i < arr.size(); i++) {
            Collections.swap(arr, l, i);
            permute(arr, l + 1, results);
            Collections.swap(arr, l, i);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 9, 8, 2};
        int maxScore = 1;

        for (int i = 0; i < A.length; i = i + 2) {
            maxScore *= (A[i] + A[i + 1]);
        }
        System.out.println("MaxScore:: " + maxScore);

        Result res = maxScoreWithMinSwaps(A);
        System.out.println("Max Score: " + res.maxScore);
        System.out.println("Min Swaps: " + res.minSwaps);
        System.out.println("Best Permutation: " + res.bestPermutation);
    }
}
