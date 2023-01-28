package recursion;

public class SubSetSum {
    public static void main(String[] args) {
        System.out.println(subSetSum(new int[] {10, 5, 2, 3, 6}, 8, 4));
    }

    public static int subSetSum(int[] subSet, int sum, int i) {
        if (i == 0) {
            if (sum == 0) return 1;
            else return 0;
        }


        return subSetSum(subSet, sum, i - 1) + subSetSum(subSet, sum - subSet[i], i - 1);
    }
}
