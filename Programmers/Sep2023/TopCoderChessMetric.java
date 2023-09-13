package Sep2023;

/**
 * Top Coder ChessMetric Collegiate Challenge Round 4 Div 1 Level 1
 */
public class TopCoderChessMetric {
    private static final int[] dx = {-2, -2, -1, -1, -1, -1, -1, 0, 0, 1, 1, 1, 1, 1, 2, 2};
    private static final int[] dy = {-1, 1, -2, -1, 0, 1, 2, -1, 1, -2, -1, 0, 1, 2, -1, 1};

    public static void main(String[] args) {
        System.out.println(howMany(3, new int[]{0, 0}, new int[]{1, 0}, 1));
        System.out.println(howMany(3, new int[]{0, 0}, new int[]{1, 2}, 1));
        System.out.println(howMany(3, new int[]{0, 0}, new int[]{2, 2}, 1));
        System.out.println(howMany(3, new int[]{0, 0}, new int[]{0, 0}, 2));
        System.out.println(howMany(100, new int[]{0, 0}, new int[]{0, 99}, 50));
    }

    private static long howMany(int size, int[] start, int[] end, int numMoves) {
        int sx = start[0], sy = start[1], ex = end[0], ey = end[1];

        long[][][] way = new long[100][100][55];
        way[sy][sx][0] = 1;

        for (int i = 1; i <= numMoves; i++) {
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    for (int d = 0; d < 16; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;

                        way[ny][nx][i] += way[y][x][i - 1];
                    }
                }
            }
        }

        return way[ey][ex][numMoves];
    }
}
