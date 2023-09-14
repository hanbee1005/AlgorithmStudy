package Sep2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Top Coder BatchSystem SRM481 Div 2 Level 3
 */
public class TopCoderBatchSystem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(schedule(new int[]{400, 100, 100, 100}, new String[]{"Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"})));
        System.out.println(Arrays.toString(schedule(new int[]{200, 200, 200}, new String[]{"Gil", "Sarah", "Warrick"})));
        System.out.println(Arrays.toString(schedule(new int[]{100, 200, 50}, new String[]{"Horatio Caine", "horatio caine", "YEAAAAAAH"})));
    }

    private static int[] schedule(int[] duration, String[] user) {
        int N = duration.length;
        int[] answer = new int[N];

        Map<String, Long> works = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = user[i];
            works.put(name, works.getOrDefault(name, 0L) + duration[i]);
        }

        boolean[] done = new boolean[N];
        int i = 0;
        while (i < N) {
            String next = "";
            // 아직 확인하지 않은 시간이 최소인 사람 구하기
            for (int n = 0; n < N; n++) {
                if (!done[n] && (next.equals("") || works.get(user[n]) < works.get(next))) {
                    next = user[n];
                }
            }

            // 현재 가장 최소 시간인 사람의 모든 업무 확인하기
            for (int n = 0; n < N; n++) {
                if (user[n].equals(next)) {
                    done[n] = true;
                    answer[i++] = n;
                }
            }
        }

        return answer;
    }
}
