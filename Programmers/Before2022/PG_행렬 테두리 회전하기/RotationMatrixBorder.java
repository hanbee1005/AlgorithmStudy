import java.util.Arrays;

public class RotationMatrixBorder {
    private static int[][] matrix;

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(solution(3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));
        System.out.println(Arrays.toString(solution(100, 97, new int[][]{{1,1,100,97}})));
    }

    private static int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows][columns];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num;
                num++;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }

        return answer;
    }

    private static int rotate(int x1, int y1, int x2, int y2) {
        int curX = x1;
        int curY = y1;

        int minValue = 10001;
        int originNum = matrix[curX][curY];

        for (int i = 0; i < 4; i++) {
            while (true) {
                if ((i == 0 && curY == y2) || (i == 1 && curX == x2) || (i == 2 && curY == y1) || (i == 3 && curX == x1)) {
                    break;
                }

                curX += dx[i];
                curY += dy[i];

                // 최솟값 구하기
                minValue = getMinValue(minValue, originNum);

                // 이동하기
                originNum = swap(curX, curY, originNum);
            }
        }

        return minValue;
    }

    private static int getMinValue(int min, int num) {
        return Math.min(min, num);
    }

    private static int swap(int curX, int curY, int originNum) {
        int tmp = 0;
        tmp = matrix[curX][curY];
        matrix[curX][curY] = originNum;
        return tmp;
    }
}