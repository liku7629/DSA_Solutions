package java8;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints(100000, 999999).limit(9).forEach(System.out::println);

        System.out.println("\n\n\n");

        random.ints().limit(9).forEach(System.out::println);
    }
}
