package Mar2022;

public class FindBiggestSquare {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
    }

    private static int solution(int [][]board)
    {
        int max = 0;

        if (board.length == 1 && board[0].length == 1 && board[0][0] == 1) return 1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1 && (i - 1) >= 0 && (j - 1) >= 0) {
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i - 1][j - 1]), board[i][j - 1]) + 1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }

        return (int) Math.pow(max, 2);
    }
}
