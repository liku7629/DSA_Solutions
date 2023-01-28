package recursion;

import java.util.ArrayList;

public class PrintingSubSequences {
    public static void main(String[] args) {
        ArrayList<Integer> path = new ArrayList<>();
        printSubsequences(new int[] {3, 1, 2}, 0, path);
    }

    public static void printSubsequences(int[] arr, int i, ArrayList<Integer> path) {
        if (i == arr.length) {
            if (!path.isEmpty()) {
                System.out.println(path);
            }

            return;
        }

        path.add(arr[i]);
        printSubsequences(arr, i + 1, path);


        path.remove(path.size() - 1);
        printSubsequences(arr, i + 1, path);
    }
}
