package arrays;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int i = 0;
        for (int n : arr) {
            arr[i++] = n;
        }

//        System.out.println(Arrays.toString(arr));

    }
}
