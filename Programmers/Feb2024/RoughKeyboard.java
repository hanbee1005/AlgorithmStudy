package Feb2024;

import java.util.Arrays;

/**
 * Level 1. 대충 만든 자판
 */
public class RoughKeyboard {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"})));
        System.out.println(Arrays.toString(solution(new String[]{"AA"}, new String[]{"B"})));
        System.out.println(Arrays.toString(solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA","BGZ"})));
    }

    private static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        int[] alphabet = new int[26];

        for (String key: keymap) {
            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'A';
                alphabet[idx] = alphabet[idx] == 0 ? (i+1) : Math.min(alphabet[idx], i+1);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            for (char t : targets[i].toCharArray()) {
                int idx = t - 'A';
                if (alphabet[idx] == 0) {
                    answer[i] = -1;
                    break;
                }

                answer[i] += alphabet[idx];
            }
        }

        return answer;
    }
}
