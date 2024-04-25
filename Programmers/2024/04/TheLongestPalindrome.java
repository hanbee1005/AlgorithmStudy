package Apr2024;

/**
 * Level 3. 가장 긴 팰린드롬
 */
public class TheLongestPalindrome {
    public static void main(String[] args) {
        System.out.println(solution("abcdcba"));
        System.out.println(solution("abacde"));
    }

    private static int solution(String s) {
        int answer = 0;
        int n = s.length();

        loop:
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j + i <= n; j++) {
                boolean flag = true;
                int start = j;
                int end = j + i - 1;

                while (start < end) {
                    if (s.charAt(start) != s.charAt(end)) {
                        flag = false;
                        break;
                    }

                    start++;
                    end--;
                }

                if (flag) {
                    answer = i;
                    break loop;
                }
            }
        }

        return answer;
    }
}
