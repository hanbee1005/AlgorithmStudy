package Mar2024;

import java.util.Arrays;

/**
 * Level 2. 광물 캐기
 */
public class MiningMinerals {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
        System.out.println(solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }

    private static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int total = Math.min(Arrays.stream(picks).sum() * 5, minerals.length);
        int round = total % 5 == 0 ? total / 5 : total / 5 + 1;

        int[][] mining = new int[round][3];
        for (int i = 0; i < round; i++) {
            int[] m = new int[3];
            int cur = i * 5;
            for (int j = cur; j < Math.min(cur + 5, minerals.length); j++) {
                switch (minerals[j]) {
                    case "diamond": m[0] += 25; break;
                    case "iron": m[1] += 5; break;
                    case "stone": m[2] += 1; break;
                }
            }

            mining[i] = m;
        }

        Arrays.sort(mining, (a1, a2) -> Arrays.stream(a2).sum() - Arrays.stream(a1).sum());

        for (int[] cur : mining) {
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
                break;
            }

            if (picks[0] > 0) {
                answer += (cur[0] / 25 + cur[1] / 5 + cur[2]);
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += (cur[0] / 5 + cur[1] / 5 + cur[2]);
                picks[1]--;
            } else {
                answer += (cur[0] + cur[1] + cur[2]);
                picks[2]--;
            }
        }

        return answer;
    }
}
