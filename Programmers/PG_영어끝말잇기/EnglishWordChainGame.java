package Dec;

import java.util.*;

public class EnglishWordChainGame {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    private static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // Queue에 사용자 넣기
        Queue<int[]> users = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            users.offer(new int[]{i, 1});
        }

        // Set에 사용한 단어 넣기
        Set<String> usedWord = new HashSet<>();

        String beforeWord = "";
        for (String word : words) {
            int[] user = users.poll();

            // 끝말잇기 성공
            if (!usedWord.contains(word)) {
                if (beforeWord.equals("") || (beforeWord.charAt(beforeWord.length() - 1) == word.charAt(0))) {
                    usedWord.add(word);
                    beforeWord = word;
                    users.offer(new int[]{user[0], user[1] + 1});
                    continue;
                }
            }

            // 끝말잇기 실패
            answer[0] = user[0];
            answer[1] = user[1];
            break;
        }

        return answer;
    }
}
