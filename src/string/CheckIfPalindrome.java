package string;

public class CheckIfPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
    }

    public static int isPalindrome(String S) {
        int n = S.length();

        System.out.println("Array length: " + S + " l=" + n);

        char[] chars = new char[n];

        int j = 0;

        for (int i = n - 1; i >= 0; i++) {
            chars[i] = S.charAt(j++);
        }

        String sr = new String(chars);

        return sr.equals(S) == true ? 1 : 0;

        // return 1;
    }
}
