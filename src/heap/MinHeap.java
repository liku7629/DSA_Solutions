package heap;

import java.util.Arrays;

public class MinHeap {
    public int arr[];
    int size;

    MinHeap(int c) {
        arr = new int[c];
        size = 0;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int getMin() {
        if (size == 0)
            return Integer.MAX_VALUE;

        return arr[0];
    }

    public int extractMin() {
        if (size == 0)
            return Integer.MIN_VALUE;

        swap(0, size - 1, arr);
        size--;
        minHeapify(0);

        return arr[size];
    }

    public void insert(int element) {
        if (size == arr.length)
            increaseCapacity();

        ++size;
        arr[size - 1] = element;

        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
            swap(i, parent(i), arr);
            i = parent(i);
        }
    }

    public void increaseCapacity() {
        int[] newArr = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public void minHeapify(int root) {
        int left = left(root), right = right(root);
        int smallest = root;

        if (left < size && arr[left] < arr[root]) {
            smallest = left;
        }

        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != root) {
            swap(root, smallest, arr);
            minHeapify(smallest);
        }
    }

    public void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(5);
        System.out.println(Arrays.toString(minHeap.arr));

        minHeap.insert(4);
        System.out.println(Arrays.toString(minHeap.arr));

        minHeap.insert(3);
        System.out.println(Arrays.toString(minHeap.arr));

        minHeap.insert(2);
        System.out.println(Arrays.toString(minHeap.arr));

        minHeap.insert(7);
        System.out.println(Arrays.toString(minHeap.arr));

        minHeap.insert(1);
        System.out.println(Arrays.toString(minHeap.arr));


        System.out.println("min=" + minHeap.extractMin());
        System.out.println(Arrays.toString(minHeap.arr));

        System.out.println("min=" + minHeap.extractMin());
        System.out.println(Arrays.toString(minHeap.arr));

        System.out.println("min=" + minHeap.extractMin());
        System.out.println(Arrays.toString(minHeap.arr));

        System.out.println("min=" + minHeap.extractMin());
        System.out.println(Arrays.toString(minHeap.arr));

        System.out.println("min=" + minHeap.extractMin());
        System.out.println(Arrays.toString(minHeap.arr));

        System.out.println("min=" + minHeap.extractMin());
        System.out.println(Arrays.toString(minHeap.arr));

        System.out.println("min=" + minHeap.extractMin());
        System.out.println(Arrays.toString(minHeap.arr));
    }
}
