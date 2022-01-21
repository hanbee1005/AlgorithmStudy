import java.util.*;

public class Delivery {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }

    private static int solution(int N, int[][] road, int K) {
        int[][] distance = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) continue;
                distance[i][j] = 500001;
            }
        }

        for (int[] r : road) {
            distance[r[0]][r[1]] = Math.min(distance[r[0]][r[1]], r[2]);
            distance[r[1]][r[0]] = Math.min(distance[r[1]][r[0]], r[2]);
        }

        // k: 거쳐가는 어떤 지점
        for (int k = 1; k <= N; k++) {
            // i : 시작점
            for (int i = 1; i <= N; i++) {
                // j : 도착점
                for (int j = 1; j <= N; j++) {
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }

        Set<Integer> answer = new HashSet<>();
        answer.add(1);

        for (int i = 1; i <= N; i++) {
            if (distance[1][i] > 0 && distance[1][i] <= K) answer.add(i);
        }

        return answer.size();
    }
}
