package math;

import java.util.ArrayList;

public class PalindromeNumber {

    public static final ArrayList list = new ArrayList();

    public static void main(String[] args) {
//        System.out.println(isPalindrome(363));
//        System.out.println(isPalindrome(364));

        for (int i = 0; true; i++) {
            System.out.println("Adding objects i=" + i);
            list.add(new Object());
        }
    }

    // Reverse the input number and compare
    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reverse = 0;

        while (number > 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }

        return originalNumber == reverse;
    }
}
