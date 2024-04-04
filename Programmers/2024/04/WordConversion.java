package Apr2024;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Level 3. 단어 변환 (DFS/BFS)
 */
public class WordConversion {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    private static int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!List.of(words).contains(target)) {
            return answer;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{-1, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            String w = cur[0] == -1 ? begin : words[cur[0]];

            if (target.equals(w)) {
                return cur[1];
            }

            for (int i = 0; i < words.length; i++) {
                if (cur[0] != i && compareString(w, words[i])) {
                    queue.add(new int[]{i, cur[1] + 1});
                }
            }
        }

        return answer;
    }

    private static boolean compareString(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}
