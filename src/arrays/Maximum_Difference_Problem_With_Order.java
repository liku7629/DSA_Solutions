package arrays;

public class Maximum_Difference_Problem_With_Order {

}

class Maximum_Difference_Problem_With_Order_BruteForce_Solution {
    public int maximumDifference(int[] arr) {
        int res = arr[1] - arr[0];

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }
        }

        if (res <= 0) {
            res = -1;
        }

        return res;
    }
}

class Maximum_Difference_Problem_With_Order_Optimized_Solution {
    public int maximumDifference(int[] arr) {
        int res = arr[1] - arr[0];

        int minValue = arr[0];

        for(int i = 1; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
            res = Math.max(res, arr[i] - minValue);
        }

        if (res <= 0) {
            res = -1;
        }

        return res;
    }
}

