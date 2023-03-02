package string;

public class ReverseWordsinaStringIII {

}

//Time: O(n)
//Space:O(n)
class ReverseWordsinaStringIII_Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < words.length; i++) {
            sb.append(reverseWord(words[i]));
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public String reverseWord(String s) {
        char[] chars = s.toCharArray();

        int start = 0, end = s.length() - 1;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return new String(chars);
    }
}
