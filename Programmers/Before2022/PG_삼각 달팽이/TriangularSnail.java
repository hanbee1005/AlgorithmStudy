import java.util.Arrays;

public class TriangularSnail {
    private static final int[] dx = {1, 0, -1};
    private static final int[] dy = {-1, 2, -1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }

    private static int[] solution(int n) {
        int finalNum = getFinalNum(n);
        int[] answer = new int[finalNum];
        int[][] matrix = new int[n][n * 2 - 1];

        int setNum = 1;
        int sx = 0;
        int sy = (n * 2 - 1) / 2;
        int direct = 0;
        while (setNum <= finalNum) {
            matrix[sx][sy] = setNum;

            int nx = sx + dx[direct];
            int ny = sy + dy[direct];

            // 다음으로 이동할 위치가 범위 내에 포함되어 있고 아직 다른 숫자로 채워지지 않은 경우
            if ((nx >= 0 && nx < n && ny >= 0 && ny < (n * 2 - 1)) && matrix[nx][ny] == 0) {
                sx = nx;
                sy = ny;
            } else {  // 방향을 바꿔야 하는 경우
                direct = (direct + 1) % 3;
                sx += dx[direct];
                sy += dy[direct];
            }
            setNum++;
        }

        int idx = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    answer[idx] = matrix[i][j];
                    idx++;
                }
            }
        }

        return answer;
    }

    private static int getFinalNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
