package Jun2024;

/**
 * Level 3. 외벽 점검
 */
public class CheckTheExteriorWall {
    private static int[] weakCases;
    private static int answer;
    public static void main(String[] args) {
        System.out.println(solution(12, new int[]{1,5,6,10}, new int[]{1,2,3,4}));
        System.out.println(solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
    }

    private static int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;

        // 반시계 방향도 처리할 수 있게 배열 확장: 1,5,6,10,13,17,18,22
        weakCases = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            weakCases[i] = weak[i];
            weakCases[i + weak.length] = weak[i] + n;
        }

        // 시작 위치를 바꾸면서 탐색
        for (int s = 0; s < weak.length; s++) {
            dfs(s, 0, dist, new boolean[dist.length], new int[dist.length]);
        }

        if (answer == Integer.MAX_VALUE) return -1;

        return answer;
    }

    private static void dfs(int start, int depth, int[] dist, boolean[] visited, int[] permuted) {
        if (depth == dist.length) {
            answer = Math.min(answer, check(start, start + weakCases.length / 2, permuted));
            return;
        }

        for (int d = dist.length - 1; d >= 0; d--) {
            if (visited[d]) continue;

            visited[d] = true;
            permuted[depth] = dist[d];
            dfs(start, depth + 1, dist, visited, permuted);
            visited[d] = false;
        }
    }

    private static int check(int start, int end, int[] permuted) {
        int friend = 1;
        int pos = weakCases[start] + permuted[friend - 1]; // 첫 취약점의 위치 + 친구 거리에서 시작
        for (int i = start; i < end; i++) {
            if (pos < weakCases[i]) { // 점검 위치를 벗어나면
                friend++; // 친구 추가
                if (friend > permuted.length) return Integer.MAX_VALUE; // 친구 수를 초과하면 실패
                pos = weakCases[i] + permuted[friend - 1];
            }
        }

        return friend;
    }
}
