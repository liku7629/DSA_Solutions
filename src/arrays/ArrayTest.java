package arrays;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(100000);

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int i = 0;
        for (int n : arr) {
            arr[i++] = n;
        }

//        System.out.println(Arrays.toString(arr));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YMMddHHmmssSSS");
        HashSet<Long> set = new HashSet<>();

        for (int j = 0; j < 20; j++) {
            Thread.sleep(1);
            Long id = Long.valueOf(LocalDateTime.now().format(formatter));
            System.out.println(id);

            if (!set.add(id)) {
                System.out.println(id + " duplicate id found");
            }
        }


        for (int j = 0; j < 200; j++) {
            int stan = atomicInteger.incrementAndGet();
            System.out.println("stan= " + stan);
            if (stan == 999999) {
                System.out.println("\n\n Reseting stan to 100000 \n\n");
                atomicInteger.set(100000);

            }
        }
    }

    public static Long generateUniqueId() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YMMddHHmmssSSS");
        return Long.valueOf(LocalDateTime.now().format(formatter));
    }

    public static int generateStan() {
        int stan = atomicInteger.incrementAndGet();
        System.out.println("stan= " + stan);
        if (stan == 999999) {
            System.out.println(stan + " Reseting stan to 100000");
            atomicInteger.set(100000);
        }
        return stan;
    }
}
