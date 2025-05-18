package java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiCoding {
    public static void main(String[] args) {
//        multiply_All_Array_Elements(new int[] {1, 2, 3, 4, 5});
//        printSumOfAllNumbers(new int[] {1, 2, 3, 4, 5, 6});
//        Print_odd_and_Even_list();
//        flatMapEmployeeNamesGetNameStream();
        peekTest();
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

    public static void  Print_odd_and_Even_list() {
        int[] arr1= new int[]{1,2,4,6,7};
        Map<String, List<Integer>> collect = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.groupingBy(t -> t % 2 == 0 ? "ODD" : "EVEN"));
        System.out.println(collect);
    }

    public static void flatMapEmployeeNamesGetNameStream() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(namesFlatStream);
    }

    public static void peekTest() {
        List<String> names = Arrays.asList("Bezos", "Gates", "Zuckerberg");

        names.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());

    }
}
