package Mar2022;

import java.util.Arrays;

public class ArcheryTournament {
    private static int maxDiff = 0;
    private static int[] answer = new int[]{-1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
    }

    private static int[] solution(int n, int[] info) {
        checkGetScore(0, n, new int[11], info);
        return answer;
    }

    private static void checkGetScore(int idx, int arrows, int[] ryan, int[] apeach) {
        if (idx == 11 || arrows == 0) {
            ryan[10] += arrows; // 남은 화살을 모두 0점에 쏘기
            calcScore(ryan, apeach);
            ryan[10] -= arrows;
            return;
        }

        // idx의 점수를 얻기로 한 경우
        if (apeach[idx] < arrows) {
            ryan[idx] += apeach[idx] + 1;
            checkGetScore(idx+1, arrows - ryan[idx], ryan, apeach);
            ryan[idx] -= apeach[idx] + 1;
        }

        // idx의 점수를 얻지 않기로 한 경우
        checkGetScore(idx+1, arrows, ryan, apeach);
    }

    private static void calcScore(int[] ryan, int[] apeach) {
        int ryanScore = 0;
        int apeachScore = 0;

        for (int i = 0; i <= 10; i++) {
            if (ryan[i] > apeach[i]) {  // ryan이 점수를 가져가는 경우
                ryanScore += (10 - i);
            } else if (apeach[i] > 0) {
                apeachScore += (10 - i);
            }
        }

        int diff = ryanScore - apeachScore;
        if (diff > 0 && diff >= maxDiff) {
            if (diff == maxDiff && !isBetter(ryan)) return;

            maxDiff = diff;
            answer = ryan.clone();
        }
    }

    private static boolean isBetter(int[] ryan) {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > answer[i]) return true;
            else if (ryan[i] < answer[i]) return false;
        }

        return false;
    }
}
