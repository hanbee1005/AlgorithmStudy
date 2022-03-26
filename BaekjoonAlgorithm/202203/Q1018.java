package Mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1018 {
    private static List<String[][]> chessBoard = new ArrayList<>(){{
        add(new String[][]{
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"}
        });
        add(new String[][]{
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"}
        });
    }};

    public static void main(String[] args) throws IOException {
        int answer = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] board = new String[xy[0]][xy[1]];
        for (int i = 0; i < xy[0]; i++) {
            board[i] = br.readLine().split("");
        }

        for (int n = 0; n < board.length - 8 + 1; n++) {
            for (int m = 0; m < board[n].length - 8 + 1; m++) {
                String[][] tmp = getTmpBoard(n, m, board);
                answer = Math.min(answer, checkNeedPaint(tmp));
            }
        }

        System.out.println(answer);
    }

    private static String[][] getTmpBoard(int sx, int sy, String[][] board) {
        String[][] tmp = new String[8][8];
        int nx = sx;
        for (int i = 0; i < 8; i++) {
            int ny = sy;
            for (int j = 0; j < 8; j++) {
                tmp[i][j] = board[nx][ny];
                ny++;
            }
            nx++;
        }

        return tmp;
    }

    private static int checkNeedPaint(String[][] board) {
        int paintCount = Integer.MAX_VALUE;
        for (String[][] chess : chessBoard) {
            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (!chess[i][j].equals(board[i][j])) {
                        count++;
                    }
                }
            }
            paintCount = Math.min(paintCount, count);
        }

        return paintCount;
    }
}
