package Feb2024;

import java.util.Arrays;

/**
 * Level 1. 가장 가까운 같은 글자
 */
public class TheClosestSameLetter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
        System.out.println(Arrays.toString(solution("foobar")));
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            answer[i] = alphabet[idx] == -1 ? alphabet[idx] : i - alphabet[idx];
            alphabet[idx] = i;
        }

        return answer;
    }
}
