package Feb2024;

/**
 * Level 1. 이웃한 칸
 */
public class AdjacentCompartment {
    public static void main(String[] args) {
        System.out.println(solution(
                new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"},
                        {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}}, 1, 1));

        System.out.println(solution(new String[][]{{"yellow", "green", "blue"}, {"blue", "green", "yellow"},{"yellow", "blue", "blue"}}, 0, 1));
    }

    private static int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for (int i = 0; i < 4; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            if (h_check >= 0 && h_check < board.length && w_check >= 0 && w_check < board.length) {
                answer += board[h][w].equals(board[h_check][w_check]) ? 1 : 0;
            }
        }

        return answer;
    }
}
