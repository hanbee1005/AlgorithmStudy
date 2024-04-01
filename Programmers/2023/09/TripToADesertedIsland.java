package Sep2023;

import java.util.*;

/**
 * Level 2. 무인도 여행
 */
public class TripToADesertedIsland {
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
        System.out.println(Arrays.toString(solution(new String[]{"XXX","XXX","XXX"})));
    }

    private static int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        String[][] matrix = new String[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            matrix[i] = maps[i].split("");
        }

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!matrix[i][j].equals("X") && !visited[i][j]) {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    visited[i][j] = true;

                    int sum = 0;

                    while (!stack.isEmpty()) {
                        int[] pos = stack.pop();
                        sum += Integer.parseInt(matrix[pos[0]][pos[1]]);

                        for (int d = 0; d < 4; d++) {
                            int nx = pos[0] + dx[d];
                            int ny = pos[1] + dy[d];

                            if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[i].length) {
                                if (!matrix[nx][ny].equals("X") && !visited[nx][ny]) {
                                    stack.push(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }

                    answer.add(sum);
                }
            }
        }

        if (answer.isEmpty()) answer.add(-1);

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
}
