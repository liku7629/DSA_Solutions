package string;

// https://leetcode.com/problems/add-strings/description/
public class AddStrings {

}

class AddStrings_Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int value = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            sb.append(value);

            i--;
            j--;
        }

        if (carry != 0)
            sb.append(carry);


        System.out.println(sb);

        return sb.reverse().toString();
    }
}
