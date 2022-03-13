package Mar2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Friends4Block {
    private static int[][] dx = {{0, -1, -1}, {-1, -1, 0}, {1, 1, 0}, {0, 1, 1}};
    private static int[][] dy = {{-1, -1, 0}, {0, 1, 1}, {0, -1, -1}, {1, 1, 0}};

    private static String[][] matrix;

    public static void main(String[] args) {
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    private static int solution(int m, int n, String[] board) {
        int answer = 0;

        // 1. Matrix 생성
        matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i].split(""), 0, matrix[i], 0, n);
        }

        while (true) {
            // 2. 주변 확인 (Set에 지워진 위치 저장)
            Set<String> toBeRemoved = checkDirection(m, n);

            // 3. 지워진 위치가 없는 경우 종료
            if (toBeRemoved.isEmpty()) break;
            else answer += toBeRemoved.size();

            // 4. Matrix 재정비
            removeAndArrangeMatrix(toBeRemoved, m, n);
        }

        return answer;
    }

    private static Set<String> checkDirection(int m, int n) {
        Set<String> toBeRemoved = new HashSet<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y].equals("")) continue;

                for (int a = 0; a < 4; a++) {
                    int isCor = 0;
                    for (int b = 0; b < 3; b++) {
                        int nx = x + dx[a][b];
                        int ny = y + dy[a][b];

                        if (!(nx >= 0 && nx < m && ny >= 0 && ny < n)) {
                            break;
                        }

                        if (matrix[x][y].equals(matrix[nx][ny])) isCor++;
                    }

                    if (isCor == 3) {
                        toBeRemoved.add(x + "," + y);
                        for (int b = 0; b < 3; b++) {
                            toBeRemoved.add((x + dx[a][b]) + "," + (y + dy[a][b]));
                        }
                    }
                }
            }
        }

        return toBeRemoved;
    }

    private static void removeAndArrangeMatrix(Set<String> toBeRemoved, int m, int n) {
        toBeRemoved.forEach(removePos -> {
            Integer[] xy = Arrays.stream(removePos.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toArray(Integer[]::new);
            matrix[xy[0]][xy[1]] = "";
        });

        for (int y = 0; y < n; y++) {
            for (int x = m - 1; x >= 0; x--) {
                if (!matrix[x][y].equals("")) continue;

                int i = x - 1;
                while(i >= 0) {
                    if (!matrix[i][y].equals("")) {
                        matrix[x][y] = matrix[i][y];
                        matrix[i][y] = "";
                        break;
                    }

                    i--;
                }
            }
        }
    }
}
