package arrays;

//https://bit.ly/3pFvBcN
public class SecondLargestElementInArray {

}

class SecondLargestElementInArray_Solution {

    //duplicates not allowed
    int print2largest(int arr[], int n) {
        int largest = -1;
        int secondLargest = -1;

        for (int element : arr) {
            if (element > largest) {
                secondLargest = largest;
                largest = element;
            }
            // if element is less than the largest and greator than the second largest
            // it should not be equal
            else if (element > secondLargest && element < largest) {
                secondLargest = element;
            }
        }

        return secondLargest;
    }
}


