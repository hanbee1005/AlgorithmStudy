import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJAlgo_6593 {
    private static int[] dz = {-1, 1, 0, 0, 0, 0};
    private static int[] dx = {0, 0, -1, 1, 0, 0};
    private static int[] dy = {0, 0, 0, 0, -1, 1};

    private static int l;
    private static int r;
    private static int c;

    private static String[][] building;

    private static int sz;
    private static int sx;
    private static int sy;
    private static int ez;
    private static int ex;
    private static int ey;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            building = new String[l][r];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String tmp = br.readLine();
                    for (int k = 0; k < tmp.length(); k++) {
                        if (tmp.charAt(k) == 'S') {
                            sz = i;
                            sx = j;
                            sy = k;
                        } else if (tmp.charAt(k) == 'E') {
                            ez = i;
                            ex = j;
                            ey = k;
                        }
                    }
                    building[i][j] = tmp;
                }
                br.readLine();
            }

            int result = bfs();
            if (result != 0) {
                System.out.println("Escaped in " + result + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }

    }

    private static int bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        queue.offer(new int[]{0, sz, sx, sy});

        boolean[][][] visited = new boolean[l][r][c];
        visited[sz][sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[1] == ez && current[2] == ex && current[3] == ey) {
                return current[0];
            }

            for (int d = 0; d < 6; d++) {
                int nz = current[1] + dz[d];
                int nx = current[2] + dx[d];
                int ny = current[3] + dy[d];

                if (nz >= 0 && nz < l && nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (building[nz][nx].charAt(ny) != '#' && !visited[nz][nx][ny]) {
                        queue.offer(new int[]{current[0] + 1, nz, nx, ny});
                        visited[nz][nx][ny] = true;
                    }
                }
            }
        }

        return 0;
    }
}
