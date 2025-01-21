package array;

public class GridGame_2017 {
    public static void main(String[] args) {
        System.out.println(gridGame(new int[][]{{2,5,4},{1,5,1}}));
        System.out.println(gridGame(new int[][]{{3,3,1},{8,5,2}}));
        System.out.println(gridGame(new int[][]{{1,3,1,15},{1,3,3,1}}));
    }

    private static long gridGame(int[][] grid) {
        long answer = Long.MAX_VALUE;
        int n = grid[0].length;

        long s1 = 0; //suffix sum of the points in the first row
        for (int v : grid[0]) {
            s1 += v;
        }

        long s2 = 0; //prefix sum of the points in the second row
        for (int j = 0; j < n; j++) { //j = find optimal position to go down
            s1 -= grid[0][j];
            answer = Math.min(answer, Math.max(s1, s2));
            s2 += grid[1][j];
        }

        return answer;
    }
}
