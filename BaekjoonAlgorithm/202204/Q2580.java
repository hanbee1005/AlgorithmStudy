package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2580 {
    private static int[][] matrix = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }

        sudoku(0, 0);
    }

    private static void sudoku(int x, int y) {
        // 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
        if (y == 9) {
            sudoku(x + 1, 0);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (x == 9) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    buffer.append(matrix[i][j]).append(" ");
                }
                buffer.append("\n");
            }

            System.out.println(buffer);
            System.exit(0);
        }

        // 만약 해당 위치의 값이 0 이라면 1부터 9까지 중 가능한 수 탐색
        if (matrix[x][y] == 0) {
            for (int n = 1; n <= 9; n++) {
                if (isPossible(x, y, n)) {
                    matrix[x][y] = n;
                    sudoku(x, y + 1);
                }
            }

            matrix[x][y] = 0;
            return;
        }

        sudoku(x, y + 1);
    }

    private static boolean isPossible(int x, int y, int value) {
        // 가로 확인
        for (int i = 0; i < 9; i++) {
            if (matrix[x][i] == value) {
                return false;
            }
        }

        // 세로 확인
        for (int i = 0; i < 9; i++) {
            if (matrix[i][y] == value) {
                return false;
            }
        }

        // 3*3 칸에 중복되는 원소가 있는지 검사
        int set_row = (x / 3) * 3;	// value가 속한 3x3의 행의 첫 위치
        int set_col = (y / 3) * 3;	// value가 속한 3x3의 열의 첫 위치

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (matrix[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
