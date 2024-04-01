package Sep2023;

/**
 * Top Coder FloorBoards SRM383 Div 1 Level 2
 */
public class TopCoderFloorBoards {
    public static void main(String[] args) {
        System.out.println(layout(new String[]{".....", ".....", ".....", ".....", "....."}));
        System.out.println(layout(new String[]{".......", ".#..##.", ".#.....", ".#####.", ".##..#.", "....###"}));
        System.out.println(layout(new String[]{"####", "####", "####", "####"}));
        System.out.println(layout(new String[]{"...#..", "##....", "#.#...", ".#....", "..#...", "..#..#"}));
        System.out.println(layout(new String[]{".#....", "..#...", ".....#", "..##..", "......", ".#..#."}));
    }

    private static int layout(String[] room) {
        int i, j, k, len = room[0].length();
        int MAX = 99999;  // 존재할 수 없는 곳에 적당히 큰 숫자를 넣습니다.
        int[] dp = new int[1 << len];
        for (i = 0; i < (1 << len); i++) {
            dp[i] = MAX;
        }
        dp[0] = 0;

        // 1칸씩 차근차근 처리합니다.
        for (i = 0; i < room.length; i++) {
            for (j = 0; j < room[0].length(); j++) {
                int[] nextdp = new int[1 << len];
                for (k = 0; k < (1 << len); k++) {
                    nextdp[k] = MAX;
                }

                for (k = 0; k < (1 << len); k++) {
                    if (dp[k] == MAX) {
                        continue;
                    }

                    int next0 = (k << 1) & ((1 << len) - 1);  // 벽 또는 가로 선을 놏는 패턴
                    int next1 = next0 + 1;  // 세로 선을 놓는 패턴
                    if (room[i].charAt(j) == '#') {  // 현재 칸이 벽인 경우
                        nextdp[next0] = Math.min(nextdp[next0], dp[k]);
                    } else  {  // 벽이 아닌 경우
                        // 세로 선을 놓는 자리
                        if (i != 0 && room[i - 1].charAt(j) != '#' && (k >> (len - 1)) % 2 == 1) {
                            nextdp[next1] = Math.min(nextdp[next1], dp[k]);
                        } else {
                            nextdp[next1] = Math.min(nextdp[next1], dp[k] + 1);
                        }

                        // 가로 선을 놓는 처리
                        if (j != 0 && room[i].charAt(j -1) != '#' && k % 2 == 0) {
                            nextdp[next0] = Math.min(nextdp[next0], dp[k]);
                        } else {
                            nextdp[next0] = Math.min(nextdp[next0], dp[k] + 1);
                        }
                    }
                }
                dp = nextdp;
            }
        }

        // 모든 상태에서 가장 적은 개수가 답
        int res = MAX;
        for (i = 0; i < (1 << len); i++) res = Math.min(res, dp[i]);

        return res;
    }
}
