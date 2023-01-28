package arrays;

import java.util.Scanner;

public class LargestElementInArray {
    public static void main(String[] args) {
//        int[] arr = {9, 5, 3, 2, 1};
        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {28, 43, 26, 65, 60, 54, 51, 35, 42, 48, 33, 40, 58, 38, 64, 47, 44, 49, 46, 25, 57, 39, 55, 45, 29, 32, 61, 53, 31, 36, 56, 63, 30, 52, 27, 34, 50, 41, 37, 66, 62, 59};
//        int[] arr = {61, 30, 28, 47, 42, 25, 41, 56, 27, 45, 44, 34, 46, 35, 58, 36, 60, 29, 53, 55, 32, 31, 33, 59, 50, 51, 52, 37, 39, 38, 43, 49, 54, 57, 40, 26, 48};


//        System.out.println(findSecondLargestElementInArray(arr));
        reverseArray(arr);
        reverseArray(new int[]{1, 2, 3, 4, 5, 6});
    }

//    public static int findLargestElementInArray(int[] arr) {
//        Arrays.sort(arr);
//        return arr[arr.length - 1];
//    }

    public static int findLargestElementInArray(int[] arr) {
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (largest < arr[i])
                largest = arr[i];
        }

        return largest;
    }

    public static int findSecondLargestElementInArray(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;


        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        int start = 0, end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}

// Java program to reverse an array without
// using "-" sign
class GFG {

    // Function to reverse array
    static void reverseArray(int arr[], int n)
    {
        // Trick to assign -1 to a variable
        int x = (Integer.MIN_VALUE / Integer.MAX_VALUE);

        // Reverse array in simple manner
        for (int i = 0; i < n / 2; i++)

            // Swap ith index value with (n-i-1)th
            // index value
            swap(arr, i, n + (x * i) + x);
    }
    static int[] swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    // Drivers code
    public static void main(String[] args)
    {
        int arr[] = { 5, 3, 7, 2, 1, 6 };
        int n = arr.length;

        reverseArray(arr, n);

        // print the reversed array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}

// This code has been contributed by 29AjayKumar
