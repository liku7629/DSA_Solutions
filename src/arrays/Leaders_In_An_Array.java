package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Leaders_In_An_Array {
    public static void main(String[] args) {

    }
}


class Leaders_In_An_Array_BruteForce_Solution {
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isLeader(i, arr)) {
                resultList.add(arr[i]);
            }
        }

        return resultList;
    }

    public static boolean isLeader(int index, int[] arr) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[index] < arr[i]) {
                return false;
            }
        }

        return true;
    }
}

class Leaders_In_An_Array_Optimized_Solution {
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> resultList = new ArrayList<>();

        int currentLeader = arr[n - 1];

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= currentLeader) {
                resultList.add(arr[i]);
                currentLeader = arr[i];
            }
        }

        Collections.reverse(resultList);

        return resultList;
    }
}

