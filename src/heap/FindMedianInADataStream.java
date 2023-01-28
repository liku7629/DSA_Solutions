package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInADataStream {
    public static void main(String[] args) {
//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(2);
//        medianFinder.addNum(3);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(4);
//        System.out.println(medianFinder.findMedian());

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());


    }
}

class MedianFinderBruteForce {

    ArrayList<Integer> list = new ArrayList<>();

    public MedianFinderBruteForce() {

    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        double res = 0.0;

        Collections.sort(list);

        if (list.size() % 2 == 0) {
            res = (double)(list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
            System.out.println(list + "   res=" + res);
            return res;
        }

        res = (double)list.get(list.size() / 2);
        System.out.println(list + "   res=" + res);
        return res;
    }
}




//optimal solution using two heaps
//divide the array into two heaps
class MedianFinder {

    PriorityQueue<Integer> minQ = new PriorityQueue(Collections.reverseOrder());
    PriorityQueue<Integer> maxQ = new PriorityQueue();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (minQ.size() > maxQ.size()) {
            if (minQ.peek() > num) {
                maxQ.add(minQ.poll());
                minQ.add(num);
            } else {
                maxQ.add(num);
            }
        } else {
            if (!maxQ.isEmpty() && num > maxQ.peek()) {
                minQ.add(maxQ.poll());
                maxQ.add(num);
            } else {
                minQ.add(num);
            }
        }
    }

    public double findMedian() {
        System.out.print("min=" + minQ);
        System.out.println("  max=" + maxQ + "   median=" + getMedian());

        if (minQ.size() == maxQ.size()) {
            return (double) (minQ.peek() + maxQ.peek()) / 2;
        }


        return minQ.peek();
    }

    public double getMedian() {
        if (minQ.size() == maxQ.size()) {
            return (double) (minQ.peek() + maxQ.peek()) / 2;
        }


        return minQ.peek();
    }
}