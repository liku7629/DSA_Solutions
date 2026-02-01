package arrays;

import java.util.ArrayList;

/**
 * You are given an array arr of positive integers. Your task is to find all the leaders in the array.
 * An element is considered a leader if it is greater than or equal to all elements to its right.
 * The rightmost element is always a leader.
 * .
 * Examples:
 * .
 * Input: arr = [16, 17, 4, 3, 5, 2]
 * Output: [17, 5, 2]
 * Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
 */

// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
public class Array_Leaders {

}

// We will iterate from the right side and keep track of the max element and add the max element to the list
class Array_Leaders_Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        if (arr.length == 0) {
            return new ArrayList<>();
        }

        int rightMax = arr[arr.length - 1];

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= rightMax) {
                list.add(0, arr[i]);
                rightMax = arr[i];
            }
        }


        return list;
    }
}
