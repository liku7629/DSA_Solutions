package basic;

import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(reverseInteger(input));
    }

    public static int reverseInteger(int number) {
        int rev = 0;
         while (number > 0) {
             rev = rev * 10 + number % 10;
             number /= 10;
         }

         return rev;
    }
}
