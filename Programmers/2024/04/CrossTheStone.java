package Apr2024;

import java.util.Arrays;

/**
 * Level 3. 징검다리 건너기
 */
public class CrossTheStone {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
        System.out.println(solution(new int[]{7, 2, 8, 7, 2, 5, 9}, 3));
    }

    private static int solution(int[] stones, int k) {
        int answer = 200001;

        if (stones.length == 1) {
            return stones[0];
        }

        int s = 0;
        int e = Arrays.stream(stones).max().orElse(200000);

        while (s <= e) {
            int mid = (s + e) / 2;

            int cnt = 0;
            int res = Integer.MIN_VALUE;

            for (int stone : stones) {
                if (stone < mid) {
                    cnt += 1;
                } else {
                    if (cnt > res) {
                        res = cnt;
                    }
                    cnt = 0;
                }
            }

            if (cnt > res) {
                res = cnt;
            }

            if (res >= k) {
                e = mid - 1;
            } else {
                answer = mid;
                s = mid + 1;
            }
        }

        /**
         * 효율성 13번에서 시간초과가 나지만 슬라이딩 윈도우 사용 방식
         *
         * int idx = 0;
         * while (idx <= stones.length - k) {
         *     int tmp = idx;
         *     int max = 0;
         *     int[] sliding = new int[k];
         *     System.arraycopy(stones, idx, sliding, 0, k);
         *
         *     for (int i = idx; i < idx + k; i++) {
         *         if (max < stones[i]) {
         *             tmp = i;
         *             max = stones[i];
         *         }
         *     }
         *
         *     answer = Math.min(answer, Arrays.stream(sliding).max().orElse(0));
         *     idx = tmp + 1;
         * }
         */



        return answer;
    }
}
