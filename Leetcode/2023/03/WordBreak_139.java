package dynamicprogramming;

import java.util.List;

public class WordBreak_139 {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet","code")));
        System.out.println(wordBreak("applepenapple", List.of("apple","pen")));
        System.out.println(wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
        System.out.println(wordBreak("aaaaaaa", List.of("aaaa","aaa")));
        System.out.println(wordBreak("dogs", List.of("dog","s","gs")));
        System.out.println(wordBreak("goalspecial", List.of("go","goal","goals","special")));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return checkWordBreak(0, s, wordDict, dp);
    }

    private static boolean checkWordBreak(int index, String s, List<String> wordDict, Boolean[] dp) {
        if (index == s.length()) return true;
        if (dp[index] != null) return dp[index];

        for (int i = index + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index, i)) && checkWordBreak(i, s, wordDict, dp)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
}
