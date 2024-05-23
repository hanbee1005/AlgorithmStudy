package May2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Level 3. 길 찾기 게임
 */
public class AWayFindingGame {
    private static List<List<Integer>> result = new ArrayList<>(){{add(new ArrayList<>()); add(new ArrayList<>());}};

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}})));
    }

    private static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        int maxLength = 0;

        List<int[]> nodeInfos = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            nodeInfos.add(new int[]{nodeinfo[i][0], nodeinfo[i][1], i + 1});
            maxLength = Math.max(maxLength, nodeinfo[i][0]);
        }

        nodeInfos.sort((n1, n2) -> n1[0] - n2[0]);
        int[][] nodes = nodeInfos.toArray(int[][]::new);
        findRootNode(nodes);

        answer[0] = result.get(0).stream().mapToInt(Integer::intValue).toArray();
        answer[1] = result.get(1).stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    private static void findRootNode(int[][] nodes) {
        if (nodes.length > 0) {
            int[] root = new int[]{0, -1, 0};
            for (int i = 0; i < nodes.length; i++) {
                int[] node = nodes[i];
                if (root[1] < node[1]) {
                    root = new int[]{i, node[1], node[2]};
                }
            }

            result.get(0).add(root[2]);
            int[][] left = Arrays.copyOfRange(nodes, 0, root[0]);
            int[][] right = Arrays.copyOfRange(nodes, root[0] + 1, nodes.length);
            findRootNode(left);
            findRootNode(right);
            result.get(1).add(root[2]);
        }
    }
}
