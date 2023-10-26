package string;

// https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {

}

//iterate from the end and check currentValue is less than lastValue
// then decrease the result else increase the result by currentValue

class RomanToInteger_Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();

        int result = 0;

        int lastValue = getIntegerValue(chars[chars.length - 1]);

        for (int i = chars.length - 1; i >= 0; i--) {
            int currentValue = getIntegerValue(chars[i]);
            // System.out.println("currentValue: " + currentValue + " lastValue: " + lastValue  + " result: " + result);
            if (currentValue < lastValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            lastValue = currentValue;
        }

        return result;
    }

    public int getIntegerValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
