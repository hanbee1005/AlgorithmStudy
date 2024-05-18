package May2024;

/**
 * Level 3. 파괴되지 않은 건물
 */
public class AnUntouchedBuilding {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}));
        System.out.println(solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new int[][]{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}}));
    }

    private static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] sums = new int[board.length + 1][board[0].length + 1];
        for (int[] sk : skill) {
            int num = sk[0] == 1 ? sk[5] * -1 : sk[5];
            sums[sk[1]][sk[2]] += num;
            sums[sk[1]][sk[4] + 1] -= num;
            sums[sk[3] + 1][sk[2]] -= num;
            sums[sk[3] + 1][sk[4] + 1] += num;
        }

        for (int x = 0; x < sums.length; x++) {
            for (int y = 1; y < sums[0].length; y++) {
                sums[x][y] += sums[x][y - 1];
            }
        }

        for (int y = 0; y < sums[0].length; y++) {
            for (int x = 1; x < sums.length; x++) {
                sums[x][y] += sums[x - 1][y];
            }
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] + sums[x][y] > 0) answer++;
            }
        }

        return answer;
    }
}
