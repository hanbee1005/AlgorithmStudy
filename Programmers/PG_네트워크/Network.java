import java.util.*;

public class Network {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;

        Map<Integer, ArrayList<Integer>> network = new HashMap<>();
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (computers[i][j] == 1){
                    ArrayList<Integer> connectedComputers = network.getOrDefault(i, new ArrayList<>());
                    if (i != j) {
                        connectedComputers.add(j);
                    }
                    network.put(i, connectedComputers);
                }
            }
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 경우
                Deque<Integer> deque = new ArrayDeque<>();
                deque.addLast(i);

                while (!deque.isEmpty()) {
                    int current = deque.pollFirst();

                    if (!visited[current]) {
                        visited[current] = true;
                        network.get(current).forEach(deque::addLast);
                    }
                }

                answer++;
            }
        }

        return answer;
    }
}
