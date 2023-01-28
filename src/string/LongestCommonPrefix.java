package string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        new LongestCommonPrefix_Solution().longestCommonPrefix(strings);
    }
}

class LongestCommonPrefix_Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int index=1;index<strs.length;index++){
            System.out.println("indexOf=" + strs[index].indexOf(prefix));
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
                System.out.println("prefix=" + prefix);
            }
        }
        return prefix;
    }
}
