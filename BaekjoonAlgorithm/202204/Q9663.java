package Apr2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nQueen(new int[n], n, 0);
        System.out.println(answer);
    }

    private static void nQueen(int[] matrix, int n, int depth) {
        // 행을 다 채운 경우 정답을 1 증가시키고 리턴
        if (n == depth) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            matrix[depth] = i;

            // isPossible() 해당 열에서 i 번째 행에 놓을 수 있는지를 검사하는 함수
            if (isPossible(matrix, depth)) {
                nQueen(matrix, n, depth + 1);
            }
        }
    }

    private static boolean isPossible(int[] matrix, int depth) {
        for (int i = 0; i < depth; i++) {
            // 해당 열의 행과 i 열의 행이 일치하는 경우 (같은 행에 존재할 경우)
            if (matrix[depth] == matrix[i]) {
                return false;
            }

            // 대각선 상에 놓여있는 경우
            // (열의 차와 행의 차가 같은 경우가 대각선에 놓인 경우이다.)
            else if (Math.abs(depth - i) == Math.abs(matrix[depth] - matrix[i])) {
                return false;
            }
        }

        return true;
    }
}