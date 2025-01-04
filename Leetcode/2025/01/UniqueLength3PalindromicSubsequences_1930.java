package string;

import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences_1930 {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    private static int countPalindromicSubsequence(String s) {
        int res = 0;
        for(char c = 'a'; c <= 'z'; c++) {
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);

            // if the char exists in the str and they're separated in a valid range
            if(first != -1 && last != -1 && first < last) {
                HashSet<Character> set = new HashSet<>();
                for(int i = first + 1; i < last; i++) { // add unqiue chars in this range into set
                    set.add(s.charAt(i));
                }

                res += set.size(); // add contents of set into our res, ex if we found abc in btwn 1st & last a chars for "a abc a", that means we can create 3 diff palindromes
            }
        }

        return res;
    }
}
