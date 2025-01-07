package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatchingInAnArray_1408 {
    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"mass","as","hero","superhero"}));
        System.out.println(stringMatching(new String[]{"leetcode","et","code"}));
        System.out.println(stringMatching(new String[]{"blue","green","bu"}));
        System.out.println(stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
    }

    private static List<String> stringMatching(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    answer.add(words[i]);
                    break;
                }
            }
        }

        return answer;
    }
}
