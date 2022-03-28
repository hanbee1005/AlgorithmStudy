package Mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q14889 {
    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] S = new int[N][N];
        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        combination(S, new boolean[N], N, N / 2, 0);

        System.out.println(minDiff);
    }

    private static void combination(int[][] s, boolean[] output, int n, int r, int start) {
        if (r == 0) {
            checkCapability(s, output, n);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!output[i]) {
                output[i] = true;
                combination(s, output, n, r - 1, i + 1);
                output[i] = false;
            }
        }
    }

    private static void checkCapability(int[][] s, boolean[] output, int n) {
        int[] startTeam = new int[n/2];
        int[] linkTeam = new int[n/2];

        int sIdx = 0;
        int lIdx = 0;
        for (int i = 0; i < n; i++) {
            if (output[i]) {
                startTeam[sIdx] = i;
                sIdx++;
            } else {
                linkTeam[lIdx] = i;
                lIdx++;
            }
        }

        minDiff = Math.min(minDiff, Math.abs(calcCapability(s, startTeam) - calcCapability(s, linkTeam)));
    }

    private static int calcCapability(int[][] s, int[] team) {
        int score = 0;
        for (int i = 0; i < team.length - 1; i++) {
            for (int j = i + 1; j < team.length; j++) {
                score += s[team[i]][team[j]] + s[team[j]][team[i]];
            }
        }

        return score;
    }
}
