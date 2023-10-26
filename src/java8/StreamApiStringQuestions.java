package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiStringQuestions {
    public static void main(String[] args) {
//        find_First_Non_Repeating_Character("strings");
        find_Occurance_Of_Every_Character("strings");

//        System.out.println(count_The_No_Of_Occurances_Of_Specific_Keyword(new String[] {"apple", "orange", "apple", "apple"}, "apple"));
    }

//    public static List<Character> find_All_Duplicate_Characters(String s) {
//
//    }

    public static Map<Character, Long> find_Occurance_Of_Every_Character(String s) {
        Map<Character, Long> result = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, Collectors.counting()
                ));


        System.out.println(result);

        return result;
    }

    public static String find_First_Non_Repeating_Character(String s) {
        Character result = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new, Collectors.counting()
                        ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();

        System.out.println(result);

        return String.valueOf(result);
    }

    public static long count_The_No_Of_Occurances_Of_Specific_Keyword(String[] array, String keyword) {
        return Arrays.stream(array)
                .filter(word -> word.equals(keyword))
                .count();
    }
}
