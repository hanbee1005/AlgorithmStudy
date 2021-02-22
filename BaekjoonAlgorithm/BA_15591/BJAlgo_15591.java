import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJAlgo_15591 {
    private static int n;
    private static Map<Integer, ArrayList<Video>> videos = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            makeVideos(a, b, r);
            makeVideos(b, a, r);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(dfs(k, v)).append("\n");
        }

        System.out.println(sb);
    }

    private static void makeVideos(int a, int b, int r) {
        if (videos.containsKey(a)) {
            videos.get(a).add(new Video(b, r));
        } else {
            videos.put(a, new ArrayList<>(Collections.singletonList(new Video(b, r))));
        }
    }

    private static int dfs(int k, int v) {
        boolean[] visited = new boolean[n + 1];
        Deque<Video> needVisit = new ArrayDeque<>(Collections.singletonList(new Video(v, 1000000000)));

        while (!needVisit.isEmpty()) {
            Video cur = needVisit.pop();
            if (!visited[cur.num] && cur.usado >= k) {
                visited[cur.num] = true;
                needVisit.addAll(videos.get(cur.num));
            }
        }

        int count = 0;
        for (boolean b : visited) {
            if (b) {
                count += 1;
            }
        }

        return count - 1;
    }

    private static class Video {
        int num;
        int usado;

        public Video(int num, int usado) {
            this.num = num;
            this.usado = usado;
        }
    }
}
