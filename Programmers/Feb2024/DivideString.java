package Feb2024;

/**
 * Level 1. 문자열 나누기
 */
public class DivideString {
    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("abracadabra"));
        System.out.println(solution("aaabbaccccabba"));
    }

    private static int solution(String s) {
        int answer = 0;

        char firstChar = ' ';
        int firstCharCount = 0;
        int otherCharCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (firstCharCount == 0) {
                firstChar = s.charAt(i);
                firstCharCount++;
                continue;
            }

            if (firstChar == s.charAt(i)) {
                firstCharCount++;
            } else {
                otherCharCount++;
            }

            if (firstCharCount == otherCharCount) {
                answer++;
                firstChar = ' ';
                firstCharCount = 0;
                otherCharCount = 0;
            }
        }

        if (firstChar != ' ') answer++;

        return answer;
    }
}
