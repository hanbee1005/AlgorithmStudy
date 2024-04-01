package Mar2024;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level 2. N-Queen
 */
public class NQueen {
    private static Queue<boolean[][]> chess = new LinkedList<>();
    private static int[] dx = {-1, 1, 1, -1};
    private static int[] dy = {-1, -1, 1, 1};


    public static void main(String[] args) {
        // System.out.println(solution(4));
        System.out.println(nQueen(4));
    }

    private static int solution(int n) {
        int answer = 0;

        chess.add(new boolean[n][n]);

        for (int i = 0; i < n; i++) {
            int depth = chess.size();
            for (int d = 0; d < depth; d++) {
                putQueen(chess.poll(), i);
            }
        }

        return chess.size();
    }

    private static void putQueen(boolean[][] current, int n) {
        for (int j = 0; j < current.length; j++) {
            if (!current[n][j]) {
                boolean[][] tmp = copy(current);

                for (int p = 0; p < tmp.length; p++) {
                    tmp[p][j] = true;
                    tmp[n][p] = true;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = n;
                    int ny = j;
                    while (true) {
                        nx += dx[d];
                        ny += dy[d];

                        if (nx < 0 || nx >= current.length || ny < 0 || ny >= current.length) {
                            break;
                        }

                        tmp[nx][ny] = true;
                    }
                }

                chess.offer(tmp);
            }
        }
    }

    private static boolean[][] copy(boolean[][] origin) {
        boolean[][] tmp = new boolean[origin.length][origin.length];
        for (int x = 0; x < tmp.length; x++) {
            for (int y = 0; y < tmp.length; y++) {
                tmp[x][y] = origin[x][y];
            }
        }
        return tmp;
    }

    /**
     * === 백트래킹을 활용한 다른 풀이 ===
     */
    public static int nQueen(int n) {
        int result = 0;
        int[] cols = new int[n];
        result = backTrack(0, cols, n);

        return result;
    }

    public static int backTrack(int level, int[] cols, int n) {
        int sum = 0;
        if (level == n) {
            return 1;
        } else {
            for (int i = 0; i < n; i++) {
                cols[level] = i;
                if (possible(level, cols)) {
                    sum += backTrack(level + 1, cols, n);
                }
            }
        }
        return sum;
    }


    public static boolean possible(int level, int[] cols) {
        for (int i = 0; i < level; i++) {
            // 이전 행(i)에 놓인 열과 현재 행(level)에 놓인 열이 같거나
            // 현재 행과 이전 행의 번호 차와 현재 행의 열과 이전 행의 열 번호 차가 같은 경우 (대각선)
            if (cols[i] == cols[level] || Math.abs(level - i) == Math.abs(cols[i] - cols[level])) {
                return false;
            }
        }
        return true;
    }
}
