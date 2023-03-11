package java8;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(9).forEach(System.out::println);
    }
}
