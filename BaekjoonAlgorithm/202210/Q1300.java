package Oct2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long lo = 1;
        long hi = N * N;

        // 이분 탐색
        // B[K] = x에 대해 x 는 left <= x < right 안의 수다.
        while (lo < hi) {
            long mid = (lo + hi) / 2; // 임의의 x를 left 와 right의 중간 값으로 잡는다.

            long count = 0;

            /*
             *  임의의 x에 대해 i번 째 행을 나눔으로써 x보다 작거나 같은 원소의 개수
             *  누적 합을 구한다.
             *  이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.
             */
            for (long i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            // 임의의 x(mid)보다 작거나 같은 수의 개수(count)와 K의 값을 비교
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}
