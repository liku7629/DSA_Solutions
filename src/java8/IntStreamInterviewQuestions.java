package java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamInterviewQuestions {

    public static void main(String[] args) {
//        System.out.println(sum_Of_All_Even_Numbers_In_An_Array_2(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));

        System.out.println(findDuplicatesUsingStream(new int[] {1, 1, 1, 2, 3, 3, 3, 4, 5}));
    }

    public static int sum_Of_All_Even_Numbers_In_An_Array(int[] arr) {
        return IntStream.of(arr)
                .filter(i -> i % 2 == 0)
                .sum();
    }

    public static int sum_Of_All_Even_Numbers_In_An_Array_2(int[] arr) {
        return Arrays.stream(arr)
                .filter(i -> i % 2 == 0)
                .sum();
    }

    public static Map<Integer, Long> findDuplicatesUsingStream(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return map;
    }
}
