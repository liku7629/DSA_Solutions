package arrays;

public class LargestElement {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 1, 3, 40, 7};

        System.out.println(findLargest(arr));
    }

    private static int findLargest(int arr[]) {
        int largest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        return largest;
    }
}
