package string;

import java.util.Arrays;

public class KmpAlgorithm {
    public static void main(String[] args) {
        printSubString("onions");
        printSubString("onionssdfas");
        printSubString("aabaaac");
    }

    public static void printSubString(String s) {
        int len = 0;
        int[] res = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(len) == s.charAt(i)) {
                len++;
                res[i] = len;
            } else {
                if (len != 0) {

                }
                res[i] = 0;
                len=0;
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
