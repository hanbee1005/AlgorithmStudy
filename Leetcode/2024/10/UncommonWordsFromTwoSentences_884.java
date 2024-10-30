package string;

import java.util.ArrayList;
import java.util.Arrays;

public class UncommonWordsFromTwoSentences_884 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple", "banana")));
    }

    private static String[] uncommonFromSentences(String s1, String s2) {
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> seen = new ArrayList<>();

        for(String word : str1) {
            if(res.contains(word)) {
                res.remove(word);
                seen.add(word);
            } else if (!seen.contains(word)) {
                res.add(word);
            }
        }

        for(String word : str2) {
            if(res.contains(word)) {
                res.remove(word);
                seen.add(word);
            } else if(!seen.contains(word)) {
                res.add(word);
            }
        }

        String[] arr = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
