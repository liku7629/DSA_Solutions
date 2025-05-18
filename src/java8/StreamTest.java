package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        findDuplicatesUsingStreamsString();
//        printInfiniteStream();
//        iterateUsingStream();
//        getMinimumNumber();
         firstNonRepeatedCharatcter("Strings");
    }

    // https://www.java-success.com/java-8-string-streams-finding-first-non-repeated-character-functional-programming/
    public static void firstNonRepeatedCharatcter(String s) {
        Character result = s.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
        System.out.println(result);
    }

    public static void getMinimumNumber() {
        Integer min = Stream.of( 3, 4, 5, 6,7, 1, 2)
//                .min(Comparator.naturalOrder()) // it will return the minimum
//                .min(Comparator.reverseOrder()) // to sort in rever
                .max(Comparator.naturalOrder()) // it will always the maximum
                .get();
        System.out.println("The Minimum number is: " + min);
    }

    public static void iterateUsingStream() {
        List<String> str = Arrays.asList("Hello","Interview","Questions","Answers");
        str.stream().forEach(System.out::println);
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
