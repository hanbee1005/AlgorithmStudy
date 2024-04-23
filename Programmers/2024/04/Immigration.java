package Apr2024;

/**
 * Level 3. 입국 심사 (이분 탐색)
 */
public class Immigration {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    private static long solution(int n, int[] times) {
        long s = 1;
        long e = (long)1000000000 * (long)1000000000;

        long answer = e;

        while (s <= e) {
            long m = (s + e) / 2;

            long cnt = 0;
            for (int time : times) {
                cnt += m / time;
            }

            if (cnt >= n) {
                answer = Math.min(answer, m);
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return answer;
    }
}
