package array;

import java.util.Arrays;

public class CountVowelStringsInRanges_2559 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}})));
        System.out.println(Arrays.toString(vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}})));
    }

    public static final String VOWELS = "aeiou";

    private static int[] vowelStrings(String[] words, int[][] queries) {
        int[] answer = new int[queries.length];

        int[] sum = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            int isVowelString = (VOWELS.indexOf(words[i].charAt(0)) != -1
                    && VOWELS.indexOf(words[i].charAt(words[i].length() - 1)) != -1) ? 1 : 0;
            sum[i + 1] = sum[i] + isVowelString;
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = sum[queries[i][1] + 1] - sum[queries[i][0]];
        }

        return answer;
    }
}
