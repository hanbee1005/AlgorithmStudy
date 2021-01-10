import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJAlgo_2206 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int n;
    private static int m;

    private static int[][] maze;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<Node> deque = new ArrayDeque();
        deque.add(new Node(0, 0, 0));

        int[][][] visited = new int[n][m][2];
        visited[0][0][0] = 1;

        while (!deque.isEmpty()) {
            Node current = deque.pollFirst();

            if (current.x == n - 1 && current.y == m - 1) {
                return visited[current.x][current.y][current.breakCount];
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maze[nx][ny] == 0 && visited[nx][ny][current.breakCount] == 0) {
                        visited[nx][ny][current.breakCount] = visited[current.x][current.y][current.breakCount] + 1;
                        deque.add(new Node(nx, ny, current.breakCount));
                    }

                    if (maze[nx][ny] == 1 && current.breakCount == 0) {
                        visited[nx][ny][1] = visited[current.x][current.y][0] + 1;
                        deque.add(new Node(nx, ny, 1));
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        int x;
        int y;
        int breakCount;

        public Node(int x, int y, int breakCount) {
            this.x = x;
            this.y = y;
            this.breakCount = breakCount;
        }
    }
}
