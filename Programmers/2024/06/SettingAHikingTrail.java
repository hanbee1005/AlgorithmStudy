package Jun2024;

import java.util.*;

/**
 * Level 3. 등산 코스 정하기
 */
public class SettingAHikingTrail {
    static List<List<Node>> graph;
    static Set<Integer> start, end;
    static int[] dist;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[]{1, 3}, new int[]{5})));
        System.out.println(Arrays.toString(solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(solution(7, new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[]{3, 7}, new int[]{1, 5})));
        System.out.println(Arrays.toString(solution(5, new int[][]{{1, 3, 10}, {1, 4, 20}, {2, 3, 4}, {2, 4, 6}, {3, 5, 20}, {4, 5, 6}}, new int[]{1, 2}, new int[]{5})));
    }

    private static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        start = new HashSet<>(); // 출발지
        end = new HashSet<>(); // 도착지

        for (int i : gates) start.add(i);
        for (int i : summits) end.add(i);

        dist = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] data : paths){
            if(!start.contains(data[1]) && !end.contains(data[0]))
                graph.get(data[0]).add(new Node(data[0], data[1], data[2]));
            if(!start.contains(data[0]) && !end.contains(data[1]))
                graph.get(data[1]).add(new Node(data[1], data[0], data[2]));
        }

        int[] answer = new int[2];
        search(answer);

        return answer;
    }

    public static void search(int[] answer){
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>();
        for (int i : start){
            for(Node node : graph.get(i))
                pq.offer(node);
        }

        answer[0] = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if (cur.weight > max) break;

            dist[cur.to] = cur.weight;

            if (end.contains(cur.to)){
                // 정상에 도착함. 최대값을 찾자.
                for (int value : dist){
                    if (value > max && value != Integer.MAX_VALUE || max == Integer.MAX_VALUE)
                        max = value;
                }

                answer[0] = Math.min(answer[0], cur.to);
                answer[1] = max;
            }

            for (int i = 0; i < graph.get(cur.to).size(); ++i){
                Node next = graph.get(cur.to).get(i);

                // 다음 지점으로 가본 적이 없는 경우.
                if(dist[next.to] == Integer.MAX_VALUE) {
                    pq.add(next);
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int weight;
        Node(int a, int b, int c){
            from = a;
            to = b;
            weight = c;
        }

        public int compareTo(Node o){
            if (this.weight == o.weight) return this.to - o.to;
            return this.weight - o.weight;
        }
    }
}
