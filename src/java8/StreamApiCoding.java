package java8;

import java.util.Arrays;

public class StreamApiCoding {
    public static void main(String[] args) {
        multiply_All_Array_Elements(new int[] {1, 2, 3, 4, 5});
        printSumOfAllNumbers(new int[] {1, 2, 3, 4, 5, 6});
    }

    public static int multiply_All_Array_Elements(int[] arr) {
        int result = Arrays.stream(arr)
                .reduce((a, b) -> {
                    System.out.println("a=" + a + " b=" + b);
                    return a * b;
                })
                .getAsInt();

        System.out.println(result);

        return result;
    }

    public static void printSumOfAllNumbers(int[] ints) {

    }
}
