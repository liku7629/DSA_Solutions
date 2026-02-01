package pattern_printing;

public class ReverseTriangle {
    public static void main(String[] args) {
        Solution.pattern8(5);
    }
}

class Solution {
    public static void pattern8(int n) {
        int leadingSpaces = 0;

        for (int i = n; i > 0; i--) {
            printSpaces(leadingSpaces);
            leadingSpaces++;

            printStars(i);
            System.out.println(' ');
        }
    }

    private static void printSpaces(int leadingSpaces) {
        for (int j = leadingSpaces; j > 0; j--) {
            System.out.print(' ');
        }
    }

    private static void printStars(int i) {
        int numberOfStart = 2 * i - 1;

        for (int k = 0; k < numberOfStart; k++) {
            System.out.print('*');
        }
    }

}