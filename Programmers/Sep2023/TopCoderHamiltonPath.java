package Sep2023;

/**
 * Top Coder Hamilton Path SRM452 Div 2 Level 3
 */
public class TopCoderHamiltonPath {
    private static final int DIVIDE_NUM = 1000000007;
    private static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(countPaths(new String[]{"NYN", "YNN", "NNN"}));
        System.out.println(countPaths(new String[]{"NYYY", "YNNN", "YNNN", "YNNN"}));
        System.out.println(countPaths(new String[]{"NYY", "YNY", "YYN"}));
        System.out.println(countPaths(new String[]{"NNNNNY", "NNNNYN", "NNNNYN", "NNNNNN", "NYYNNN", "YNNNNN"}));
    }

    private static int countPaths(String[] roads) {
        int group = 0, free = 0;
        int[] connect = new int[roads.length];
        long sum = 1;

        visited = new boolean[roads.length];

        // 같은 지점을 두번 이상 지나는 경우가 있는지 확인 (한 지점에 3개 이상 연결된 경우)
        for (int i = 0; i < roads.length; i++) {
            int y = 0;
            for (int j = 0; j < roads[i].length(); j++) {
                if ('Y' == roads[i].charAt(j)) {
                    if (2 < ++y) return 0;
                }
            }
            connect[i] = y;
        }

        // 연결이 되어 있는 경우와 단독인 경우 구분하여 수를 확인
        for (int i = 0; i < connect.length; i++) {
            if (connect[i] == 0) {
                visited[i] = true;
                free++;
            } else if (connect[i] == 1 && !visited[i]) {
                group++;
                dfs(i, roads);
            }
        }

        // 방문하지 않은 도시가 있다면 return 0
        for (boolean v : visited) {
            if (!v) return 0;
        }

        // 전체 그룹을 순서대로 놓을 수 있는 방법의 수
        for (int i = 0; i < group + free; i++) {
            sum = sum * (i + 1) % DIVIDE_NUM;
        }

        // 그룹 내에서 나올 수 있는 연결하는 수 (cycle 이 없으므로 시작점을 어디로 할지 총 2개)
        for (int i = 0; i < group; i++) {
            sum = sum * 2 % DIVIDE_NUM;
        }

        return (int) sum;
    }

    private static void dfs(int city, String[] roads) {
        visited[city] = true;
        for (int i = 0; i < roads[city].length(); i++) {
            if ('Y' == roads[city].charAt(i) && !visited[i]) {
                dfs(i, roads);
            }
        }
    }
}
