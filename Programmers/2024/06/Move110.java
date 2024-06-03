package Jun2024;

import java.util.Arrays;

/**
 * Level 3. 110 옮기기
 */
public class Move110 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"1110","100111100","0111111010"})));  // "1101","100110110","0110110111"
        System.out.println(Arrays.toString(solution(new String[]{"1011110","01110","101101111010"}))); // "1011011","01101","101101101101"
    }

    private static String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            String str = s[i];

            StringBuilder sb = new StringBuilder();
            StringBuilder tmp = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (j >= 2 && c == '0' && sb.charAt(sb.length() - 1) == '1' && sb.charAt(sb.length() - 2) == '1') {
                    tmp.append("110");
                    sb.delete(sb.length() - 2, sb.length());
                } else {
                    sb.append(c);
                }
            }

            if (tmp.length() > 0) {
                // 0이 없으면
                if (sb.indexOf("0") == -1) {
                    sb.insert(0, tmp);
                } else {
                    int idx = sb.lastIndexOf("0");
                    sb.insert(idx+1, tmp);
                }
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}
