package search;

public class BinarySearchWithDuplicates {
    public static void main(String[] args) {
//      System.out.println(binarySearch(new int[] {1, 2, 4, 5, 6, 7, 8, 9}, 2));
//        int[] arr = {5, 5, 5, 5, 5, 5, 10, 10, 15, 15, 15, 15, 20, 20, 20};
        int[] arr = {5, 5, 5, 5, 5, 5, 5, 5, 5};
        System.out.println(binarySearchRecursive(arr, 6, 0, arr.length - 1));
    }

    public static int binarySearch(int[] arr, int element) {
        int low = 0, high = arr.length - 1, mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == element) {
                if (mid > 0 && arr[mid - 1] == element)
                    high = mid - 1;
                else
                    return mid;
            } else if (element > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int element, int low, int high) {
        int mid = (low + high) / 2;

        if (low > high) {
            return -1;
        }

        if (arr[mid] == element) {
            if (mid > 0 && arr[mid - 1] == element)
                return binarySearchRecursive(arr, element, low, mid - 1);
            else
                return mid;
        } else if (element > arr[mid]) {
            low = mid + 1;
            return binarySearchRecursive(arr, element, low, high);
        } else {
            high = mid - 1;
            return binarySearchRecursive(arr, element, low, high);
        }
    }
}
