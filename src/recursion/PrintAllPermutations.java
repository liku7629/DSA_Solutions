package recursion;


public class PrintAllPermutations {
    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0);
    }

    public static void permute(String str, int l) {
        if (l == str.length() - 1) {
            System.out.println(str);
            return;
        }

        for (int i = l; i < str.length(); i++) {
            permute(swap(str, i, l), l + 1);
        }
    }

    static String swap(String s, int i, int j) {

        if (i == j) {
            return s;
        }

        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
