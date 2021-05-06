import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJAlgo_3055 {
    private static int[] xx = {-1, 1, 0, 0};
    private static int[] yy = {0, 0, -1, 1};

    private static int r;
    private static int c;

    private static char[][] forest;

    private static int sx;
    private static int sy;
    private static ArrayList<int[]> water = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        forest = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (tmp[j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (tmp[j] == '*') {
                    water.add(new int[]{i, j});
                }
            }
            forest[i] = tmp;
        }

        int result = bfs();
        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.cnt - node2.cnt != 0 ? node1.cnt - node2.cnt : node1.type - node2.type;
            }
        });

        boolean[][] w_visited = new boolean[r][c];
        boolean[][] visited = new boolean[r][c];

        for (int[] w : water) {
            queue.offer(new Node(0, '*', w[0], w[1]));
            w_visited[w[0]][w[1]] = true;
        }
        queue.offer(new Node(0, 'S', sx, sy));
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.type == 'D') {
                return current.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + xx[i];
                int ny = current.y + yy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    // 현재 위치가 물인 경우
                    if (current.type == '*') {
                        if (forest[nx][ny] != 'X' && forest[nx][ny] != 'D' && !w_visited[nx][ny]) {
                            queue.offer(new Node(current.cnt + 1, '*', nx, ny));
                            w_visited[nx][ny] = true;
                        }
                    } else {
                        if (forest[nx][ny] != 'X' && !w_visited[nx][ny] && !visited[nx][ny]) {
                            queue.offer(new Node(current.cnt + 1, forest[nx][ny], nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}

class Node {
    int cnt;
    char type;
    int x;
    int y;

    public Node(int cnt, char type, int x, int y) {
        this.cnt = cnt;
        this.type = type;
        this.x = x;
        this.y = y;
    }
}
