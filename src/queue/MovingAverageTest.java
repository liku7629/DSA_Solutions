package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverageTest {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }
}


class MovingAverage {

    Queue<Integer> queue;
    int maxWindowSize;

    double currentWindowSum;

    public MovingAverage(int size) {
        this.maxWindowSize = size;
        queue = new ArrayDeque<>(size);
    }

    public double next(int val) {
        if (queue.size() == maxWindowSize) {
            currentWindowSum = currentWindowSum + val - queue.poll();
            queue.add(val);
            return currentWindowSum / queue.size();
        }

        queue.add(val);
        currentWindowSum = currentWindowSum + val;
        return currentWindowSum / queue.size();
    }
}
