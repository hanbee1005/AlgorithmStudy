public class Network {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n]; // 연결된 컴퓨터를 확인했는지 체크
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {  // 아직 해당 컴퓨터를 확인하지 않은 경우
                dfs(computers, visited, i);  // 기준 컴퓨터와 연결된 컴퓨터를 모두 확인
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int[][] computers, boolean[] visited, int start) {
        visited[start] = true;  // 기준 컴퓨터를 확인한 것으로 처리하고
        for (int i = 0; i < computers[start].length; i++) {
            if (computers[start][i] == 1 && !visited[i]) {  // 기준 컴퓨터와 연결되어 있지만 아직 확인하지 않은 경우
                dfs(computers, visited, i);  // 다시 다음 컴퓨터를 기준으로 연결된 컴퓨터 모두 확인
            }
        }
    }
}
