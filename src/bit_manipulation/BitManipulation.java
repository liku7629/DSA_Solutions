package bit_manipulation;

// https://medium.com/@YodgorbekKomilo/bit-manipulation-in-java-a-full-guide-for-beginners-e871b59f4f76
public class BitManipulation {
    public static void main(String[] args) {
//        printEvenOdd(5);
//        printEvenOdd(6);

//        countRightMostSetBits(29); // 11101
//        reversingBitsOfANumber(12345);
        swap();
        printBitManipulation();
    }

    public static void printBitManipulation() {
        int a = 5; // Binary: 0101
        int b = 3; // Binary: 0011

        // 32 bit for int and 64 bit for long

        System.out.println("a & b: " + (a & b)); // 0001 = 1
        System.out.println("a | b: " + (a | b)); // 0111 = 7
        System.out.println("a ^ b: " + (a ^ b)); // 0110 = 6
        System.out.println("~a: " + (~a));   // 11111111111111111111111111111010 = -6
        System.out.println("a << 1: " + (a << 1)); // 1010 = 10
        System.out.println("a >> 1: " + (a >> 1)); // 0010 = 2
        System.out.println("a >>> 1: " + (a >>> 1)); // 0010 = 2
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

        System.out.println();
    }

    public static void printEvenOdd(int n) {
        if ((n & 1) == 0) {
            System.out.println(n + " is even");
        } else {
            System.out.println(n + " is odd");
        }
    }

    // To count how many bits are set (1s) in a number
    public static void countRightMostSetBits(int num) {
        int count = 0;

        System.out.println("num: " + num + " Binary: " + Integer.toBinaryString(num) + "\n");

        while (num > 0) {
            num = num & (num - 1); // Turn off the rightmost set bit
            System.out.println("num: " + num + " Binary: " + Integer.toBinaryString(num));
            count++;
        }
        System.out.println("Number of rightmost set bits: " + count);
    }

    //Reversing the bits of a number
    //You can reverse the bits of a number by iterating through each bit, shifting the bits of the number, and building the reversed result.
    public static void reversingBitsOfANumber(int num) {
        System.out.println("num: " + num + " Binary: " + Integer.toBinaryString(num) + "\n");

        int reversed = 0;
        while (num > 0) {
            reversed = (reversed << 1) | (num & 1); // Shift left and add the last bit
            num >>= 1; // Shift the number right
            System.out.println("Reversed bits: " + reversed + " Binary: " + Integer.toBinaryString(reversed));

        }
        System.out.println("Reversed bits: " + reversed + " Binary: " + Integer.toBinaryString(reversed));
    }

    // Swapping two numbers without using a temporary variable
    public static void swap() {
        int a = 5;
        int b = 10;

        System.out.println("Before Swap: a = " + a + " Binary a: " + Integer.toBinaryString(a) + ", b = " + b + " Binary a: " + Integer.toBinaryString(b) + "\n");

        a = a ^ b; // XOR a and b and store in a
        System.out.println("Swap: a = " + a + " Binary a: " + Integer.toBinaryString(a) + ", b = " + b + " Binary b: " + Integer.toBinaryString(b));

        b = a ^ b; // XOR a and b (which is now XOR of original a and b) to get the original a

        System.out.println("Swap: a = " + a + " Binary a: " + Integer.toBinaryString(a) + ", b = " + b + " Binary b: " + Integer.toBinaryString(b) + "\n");

        a = a ^ b; // XOR a and b (which is now original a and b) to get the original b

        System.out.println("After Swap: a = " + a + " Binary a: " + Integer.toBinaryString(a) + ", b = " + b + " Binary a: " + Integer.toBinaryString(b) + "\n");
    }
}