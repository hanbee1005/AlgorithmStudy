public class MinimumOperationsToMakeAUni_ValueGrid_2033 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[][]{{2,4},{6,8}}, 2));
        System.out.println(minOperations(new int[][]{{1,5},{2,3}}, 1));
        System.out.println(minOperations(new int[][]{{1,2},{3,4}}, 2));
    }

    private static int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;

        int len = m * n;
        if (len < 2) return 0;

        int[] count = new int[10001];

        // 나온 숫자의 개수 구하기
        int r = grid[0][0] % x;
        for (int[] row : grid) {
            for (int j = 0; j < n; ++j) {
                int v = row[j];
                if (v % x != r) return -1;
                count[v]++;
            }
        }

        len = (len + 1) / 2;
        int total = 0;
        int median = 0;

        // 중간 값 구하기
        for (int v = 0; v < count.length; ++v) {
            if (count[v] == 0) continue;
            total += count[v];
            if (total >= len) {
                median = v;
                break;
            }
        }

        int answer = 0;
        for (int v = 0; v <= median; ++v) {
            if (count[v] == 0) continue;
            answer += count[v] * (median - v) / x;
        }

        for (int v = median + 1; v < count.length; ++v) {
            if (count[v] == 0) continue;
            answer += count[v] * (v - median) / x;
        }

        return answer;
    }
}
