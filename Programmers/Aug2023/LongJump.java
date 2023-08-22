package Aug2023;

/**
 * Level 2. 멀리 뛰기
 */
public class LongJump {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static long solution(int n) {
        if (n == 1 || n == 2) return n;

        long answer = 0;

        long[] arr = new long[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
        }

        answer = arr[n];

        return answer;
    }
}
