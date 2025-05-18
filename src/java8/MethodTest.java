package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "1", "2", "3");

        String s = list.stream().reduce((a, b) -> {
            System.out.println("a=" + a + ", b=" + b);
            return b + a;
        }).get();
        System.out.println(s);


    }
}
