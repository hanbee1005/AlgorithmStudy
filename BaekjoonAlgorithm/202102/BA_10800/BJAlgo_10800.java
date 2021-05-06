import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_10800 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Ball> balls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls.add(new Ball(i, c, s));
        }

        Collections.sort(balls, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.size - o2.size;
            }
        });

        int[] answer = new int[n];

        int sum = 0;
        int[] color = new int[n + 1];
        for (int i = 0, j = 0; i < n; i++) {
            Ball a = balls.get(i);
            Ball b = balls.get(j);

            while (b.size < a.size) {
                sum += b.size;
                color[b.color] += b.size;

                b = balls.get(++j);
            }

            answer[a.idx] = sum - color[a.color];
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);

    }

    private static class Ball {
        int idx;
        int color;
        int size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
}
