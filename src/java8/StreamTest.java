package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        findDuplicatesUsingStreamsString();
    }

    public static void findDuplicatesUsingStreams() {
        List<Integer> numList = Arrays.asList(5, 5, 5, 3, 3, 1, 2, 4, 6);

        Map<Integer, Long> map = numList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
    }

    public static void findDuplicatesUsingStreamsString() {
        List<String> numList = Arrays.asList("abc", "abc", "cde", "efg", "efg", "efg");

        Map<String, Long> map = numList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
    }
}
