import java.util.Arrays;
import java.util.Stack;

public class CheckDistancing {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(new String[][]{
                        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                }))
        );
    }

    private static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int p = 0; p < places.length; p++) {
            String[][] place = new String[5][5];
            for (int i = 0; i < 5; i++) {
                String[] row = places[p][i].split("");
                System.arraycopy(row, 0, place[i], 0, 5);
            }

            answer[p] = dfs(place);
        }

        return answer;
    }

    private static int dfs(String[][] place) {
        int answer = 1;

        // P의 위치를 Stack에 미리 저장
        Stack<int[]> needVisit = new Stack<>();
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length; j++) {
                if ("P".equals(place[i][j])) {
                    needVisit.push(new int[]{i, j, i, j});
                }
            }
        }

        // 방문했는지 여부
        boolean[][] visited = new boolean[5][5];

        // 더 이상 이동할 위치가 없을 때까지 반복
        while (!needVisit.isEmpty()) {
            int[] node = needVisit.pop();

            for(int i = 0 ; i < 4; i++) {
                // 다음 이동 위치 확인
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                // 범위 내에 포함되어 있으면서 처음 출발했던 위치가 아닐 때
                if ((x >= 0 && x < 5 && y >= 0 && y < 5) && !(x == node[2] && y == node[3])) {
                    String next = place[x][y];
                    if (!"X".equals(next)) {  // 벽이 아닌 경우
                        // 거리 구하기
                        int dist = Math.abs(node[2] - x) + Math.abs(node[3] - y);

                        if (dist > 2) {  // 안전 거리인 경우 패스
                            continue;
                        }

                        // 맨해튼 거리가 2이하이면서 사람이 있는 경우 거리두기 위반!
                        if ("P".equals(next)) {
                            return 0;
                        } else {
                            // 사람이 없고 방문한 적 없는 위치의 경우 이동
                            if (!visited[x][y]) {
                                needVisit.push(new int[]{x, y, node[2], node[3]});
                                visited[x][y] = true;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
