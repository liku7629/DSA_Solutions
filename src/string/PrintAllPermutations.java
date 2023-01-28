package string;

public class PrintAllPermutations {
    public static void main(String[] args) {
        printAllPermutations("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, 0);
    }

    public static void printAllPermutations(String s, int i, int k) {

        if (i == s.length() - 1) {
            System.out.println(s + "  " + "i=" + i + "  j=" + k);
            return;
        }

        for (int j = i; j < s.length(); j++) {
//            System.out.println("Before swapping: " + s  + " i=" + i + "  j=" + j);
            s = swap(s, i, j);
            printAllPermutations(s, i + 1, j);
            s = swap(s, i, j);
//            System.out.println("After swapping: " + s  + " i=" + i + "  j=" + j + "\n");
        }
    }

    static String swap(String s, int i, int j) {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}
