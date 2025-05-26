package array;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter_2942 {
    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[]{"leet","code"}, 'e'));
        System.out.println(findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"}, 'a'));
        System.out.println(findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"}, 'z'));
    }

    private static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0) {
                answer.add(i);
            }
        }

        return answer;
    }
}
