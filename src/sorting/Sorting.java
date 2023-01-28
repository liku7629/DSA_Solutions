//package sorting;
//
//import java.util.Arrays;
//
//public class Sorting {
//    public static void main(String[] args) {
////        System.out.println(Arrays.toString(mergeSort(new int[] {5, 4, 3, 2, 1})));
//        System.out.println(Arrays.toString(mergeSort(new int[] {5, 4})));
//    }
//
//    public static int[] bubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1])
//                    swap(arr, j, j+1);
//                System.out.println("sorting i=" + i + "j=" +j );
//            }
//        }
//
//        return arr;
//    }
//
//    public static void swap(int[] arr, int a, int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }
//
//   public static void mergeSort(int[] arr, int left, int right) {
//        if (left > right) {
//            return;
//        }
//
//       int mid = (left + right) / 2;
//
//       mergeSort(arr, left, mid);
//       mergeSort(arr, mid + 1, right);
//
//       merge(arr, left, mid, right);
//   }
//
//    private static int[] merge(int[] arr, int left, int mid, int right) {
//        int[] firstHalf = new int[mid - left + 1];
//        int[] secondHalf = new int[right - mid];
//
//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        while (i < firstHalf.length && j < secondHalf.length) {
//            if (firstHalf[i] > secondHalf[j]) {
//                mergedArr[k] = secondHalf[j];
//                j++;
//            } else {
//                mergedArr[k] = firstHalf[i];
//                i++;
//            }
//            k++;
//        }
//
//        while (i < firstHalf.length) {
//            mergedArr[k] = firstHalf[i];
//            i++; k++;
//        }
//
//        while (j < secondHalf.length) {
//            mergedArr[k] = secondHalf[j];
//            j++; k++;
//        }
//
//        return mergedArr;
//    }
//}
