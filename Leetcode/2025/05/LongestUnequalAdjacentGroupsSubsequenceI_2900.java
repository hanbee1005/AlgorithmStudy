package greedy;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI_2900 {
    public static void main(String[] args) {
        System.out.println(getLongestSubsequence(new String[]{"c"}, new int[]{0}));
        System.out.println(getLongestSubsequence(new String[]{"d"}, new int[]{1}));
        System.out.println(getLongestSubsequence(new String[]{"a","b","c","d"}, new int[]{1,0,1,1}));
        System.out.println(getLongestSubsequence(new String[]{"d","g"}, new int[]{0,1}));
        System.out.println(getLongestSubsequence(new String[]{"c","w","h","s"}, new int[]{0,0,0,1}));
    }

    private static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> answer = new ArrayList<>();
        answer.add(words[0]);

        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != groups[i - 1])
                answer.add(words[i]);
        }

        return answer;
    }
}
