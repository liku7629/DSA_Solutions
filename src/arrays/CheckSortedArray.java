package arrays;

public class CheckSortedArray {
    public static void main(String[] args) {
        System.out.println(isSorted(new int[] {1, 2, 2, 3, 3, 3, 4, 5 }));
        System.out.println(checkSorted( new int[] {1, 2, 2, 3, 3, 3, 4, 5 }));
        System.out.println(isSorted(new int[] {5, 2, 2, 3, 3, 3, 4, 5 }));
        System.out.println(checkSorted(new int[] {5, 2, 2, 3, 3, 3, 4, 5 }));
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1])
                return false;
        }

        return true;
    }

    public static boolean checkSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

}
