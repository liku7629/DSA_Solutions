package java8;

import java.util.stream.IntStream;

public class ParallelStreamTest {
    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(currentNumber -> System.out.println(Thread.currentThread().getName() + " num: " + currentNumber));

        System.out.println(" Parallel ==============================");

        IntStream.range(1, 10).parallel().forEach(currentNumber -> System.out.println(Thread.currentThread().getName() + " num: " + currentNumber));
    }
}