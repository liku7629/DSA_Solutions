package arrays;

public class SecondLargestElement {
    public static void main(String[] args) {


        System.out.println(findSecondLargest(new int[] { 3, 4, 1, 9, 7}));
        System.out.println(findSecondLargest(new int[] { 7, 3, 4, 1, 9}));
        System.out.println(findSecondLargest(new int[] { 3, 4, 1, 7, 9}));
        System.out.println(findSecondLargest(new int[] { 3, 4, 7, 1 , 9}));
    }

    public static int findSecondLargest(int[] arr) {
        int secondLargest = 0, largest = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            if (current > largest) {
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest) {
                secondLargest = current;
            }
        }

        return secondLargest;
    }
}
