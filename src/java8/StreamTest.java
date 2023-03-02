package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        findDuplicatesUsingStreamsString();
        printInfiniteStream();
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

    public static void printInfiniteStream() {
//        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2).limit(100);
//        infiniteStream.forEach(System.out::println);

        long compound = 2;
        for (int i = 1; i <= 100; i++) {
            compound = compound * 2;
            System.out.println(i + "   " + compound);
        }
    }
}
