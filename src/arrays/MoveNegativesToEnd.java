package arrays;

import java.util.Arrays;

public class MoveNegativesToEnd {

    public static void main(String[] args) {
//        segregateElements(new int[]{1, -1, 3, 2, -7, -5, 11, 6}, 8);
        segregateElements(new int[]{-2, 10, -3, -4, 8}, 5);
    }

    public static void segregateElements(int[] arr, int n) {

        int[] negatives = new int[n];

        int j = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Copying negatives i=" + i + " ele=" + arr[i]);

            if (arr[i] < 0) {
                negatives[j++] = arr[i];
            }
        }

        System.out.println("\n");
        System.out.println(Arrays.toString(negatives) + " j=" + j);
        System.out.println("\n");

        int start = -1;

        for (int i = 0; i < n; i++) {
            System.out.println("Copying negatives i=" + i + " ele=" + arr[i]);

            if (arr[i] > 0) {
                arr[++start] = arr[i];
            }
        }

        System.out.println("\n");

        for (int i = 0; i < j; i++) {
            System.out.println("Copying negatives i=" + i + " ele=" + arr[i]);
            arr[++start] = negatives[i];
        }

        System.out.println("\n");
        System.out.println(Arrays.toString(arr) + " j=" + j);
        System.out.println("\n");
    }

}
