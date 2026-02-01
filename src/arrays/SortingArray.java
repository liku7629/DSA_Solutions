package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SortingArray {
    public static void main(String[] args) {
//        sortingArrayAscendingOrder();
//        sortingArrayDescendingOrder();
        sorting_2D_Array_AscendingOrder();
    }

    public static void sortingArrayAscendingOrder() {
        Integer[] arr = {5, 2, 8, 1, 3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortingArrayDescendingOrder() {
        Integer[] arr = {5, 2, 8, 1, 3};
        Arrays.sort(arr, (a, b) -> Integer.compare(b, a));
        System.out.println(Arrays.toString(arr));
    }

    public static void sorting_2D_Array_AscendingOrder() {
        int[][] arr = {
                {3, 5},
                {1, 2},
                {4, 1}
        };

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        for (int[] row : arr)
            System.out.println(Arrays.toString(row));
    }

}
