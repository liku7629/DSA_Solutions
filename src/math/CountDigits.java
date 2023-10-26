package math;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(getDigitCount(-999));
    }

    // Divide the number by 10 and count digits until it reaches 0
    public static int getDigitCount(int number) {
        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }

        return count;
    }
}
