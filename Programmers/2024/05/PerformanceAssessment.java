package May2024;

import java.util.Arrays;

/**
 * Level 3. 인사 고과
 */
public class PerformanceAssessment {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2,2},{1,4},{3,2},{3,2},{2,1}}));
    }

    private static int solution(int[][] scores) {
        int answer = 0;

        int wonhoScore = scores[0][0] + scores[0][1];

        int[][] filtered = Arrays.stream(scores).filter(s -> s[0] + s[1] > wonhoScore).toArray(int[][]::new);
        Arrays.sort(filtered, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]) == 0 ? (a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]) : (a[0] + a[1]) - (b[0] + b[1]));
        int[][] s = new int[filtered.length + 1][2];
        System.arraycopy(filtered, 0, s, 1, filtered.length);
        s[0] = scores[0];

        for (int i = 0; i < s.length - 1; i++) {
            int[] score = s[i];
            boolean canReceive = true;
            for (int j = i + 1; j < s.length; j++) {
                if (score[0] < s[j][0] && score[1] < s[j][1]) {
                    canReceive = false;
                    break;
                }
            }

            if (i == 0 && !canReceive) return -1;

            if (canReceive) {
                answer += 1;
            }
        }

        return answer + 1;

//        int[] s = scores[0];
//        Arrays.sort(scores, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);
//        int max = 0, ans = 1;
//        for(int[] score : scores) {
//            if(score[1] < max) {
//                if(Arrays.equals(score, s))
//                    return -1;
//            }
//            else {
//                max = score[1];
//                if(s[0] + s[1] < score[0] + score[1])
//                    ans++;
//            }
//        }
//        return ans;
    }
}
