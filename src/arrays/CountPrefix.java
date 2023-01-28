package arrays;

import java.util.Arrays;

public class CountPrefix {
    public static void main(String[] args) {
        System.out.println(countPrefixes(new String[] {"feh","w","w","lwd","c","s","vk","zwlv","n","w","sw","qrd","w","w","mqe","w","w","w","gb","w","qy","xs","br","w","rypg","wh","g","w","w","fh","w","w","sccy"},
        "w"));
    }

    public static int countPrefixes(String[] words, String s) {
        int count = 0;

        for(int i = 0; i < words.length; i++) {
            String currPrefix = words[i];

            int j = 0;
            int k = 0;

            boolean isPrefix = true;

            while (j < currPrefix.length() && k < s.length()) {
                if (currPrefix.charAt(j) != s.charAt(k)) {
                    isPrefix = false;
                }
                j++; k++;
            }



            if (isPrefix && (j == currPrefix.length())){
                System.out.println(s + "  " + currPrefix + "  " + i);
                count++;
            }
        }

        return count;
    }

//    public static int countPrefixes(String[] words, String s) {
//        return (int) Arrays.stream(words).filter(s::startsWith).count();
//    }
}

