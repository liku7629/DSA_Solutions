package recursion;

import java.util.Arrays;

public class RopeCuttingProblem {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 2, 3};

//        System.out.println(mostFrequent(arr));
        generateMatrix(3);
    }

    static int mostFrequent(int arr[]) {
        // Sort the array
        Arrays.sort(arr);

        // find the max frequency using linear traversal
        int max_count = 1, res = arr[0];
        int curr_count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                curr_count++;
            else
                curr_count = 1;

            if (curr_count > max_count) {
                max_count = curr_count;
                res = arr[i - 1];
            }
        }
        return res;
    }


    static void generateMatrix(int N) {

        // Stores odd numbers
        int num = 2;

        // Store matrix elements such that
        // sum of elements in both diagonals
        // of every 2 * 2 submatrices is even
        int[][] mat = new int[N + 1][N + 1];

        // Fill all the values of
        // matrix elements
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                mat[i][j] = num;
                num += 2;
            }
        }

        // Print the matrix
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(mat[i][j] + " ");
            }

            System.out.println();
        }
    }
}
