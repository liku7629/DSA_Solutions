package arrays;

public class MaximumDifference {
    public static void main(String[] args) {
        System.out.println(findMaxDiff(new int[] {1, 3, 10, 6, 4, 8, 2, 11}));
        System.out.println(findMaxDiff(new int[] {9,4,3,2}));
    }

    public static int findMaxDiff(int[] arr) {
        int res = -1;
        int minVal = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            minVal = Math.min(minVal, arr[i]);
            res = Math.max(res, arr[i+1] - minVal);
        }

        return res;
    }

    public static int findMaxDiffOpt(int[] arr) {
        int res = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {

        }

        return res;
    }
}
