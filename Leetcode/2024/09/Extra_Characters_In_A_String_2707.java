package dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Extra_Characters_In_A_String_2707 {
    public static void main(String[] args) {
        System.out.println(minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));
        System.out.println(minExtraChar("sayhelloworld", new String[]{"hello","world"}));
    }

    private static int minExtraChar(String s, String[] dictionary) {
        // 사전 리스트를 Set으로 변환하여 O(1) 조회 시간을 가짐
        Set<String> wordSet = new HashSet<>(List.of(dictionary));
        int n = s.length();

        // dp[i]는 부분 문자열 s[i:]에서 남는 최소한의 문자를 저장함
        int[] dp = new int[n + 1];

        // dp 배열을 오른쪽에서 왼쪽으로 채움
        for (int i = n - 1; i >= 0; i--) {
            // 기본적으로 현재 문자는 남는 문자라고 가정
            dp[i] = dp[i + 1] + 1;

            // 사전의 단어 중 s[i:]에서 시작하는 단어를 찾아서 일치하는 경우
            for (int length = 1; length <= n - i; length++) {
                if (wordSet.contains(s.substring(i, i + length))) {
                    dp[i] = Math.min(dp[i], dp[i + length]);
                }
            }
        }

        // 전체 문자열에서 남는 최소한의 문자는 dp[0]에 저장됨
        return dp[0];
    }
}
