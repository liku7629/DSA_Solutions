package search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {1, 2, 4, 5, 6, 7, 8, 9}, 1));
    }

    public static int binarySearch(int[] arr, int element) {
        int low = 0, high = arr.length -1, mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == element) return mid;
            else if (element > arr[mid]) low = mid + 1;
            else if (element < arr[mid]) high = mid - 1;
        }

        return -1;
    }

}
