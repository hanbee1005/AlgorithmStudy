package Apr2024;

/**
 * Level 2. 유사 칸토어 비트열
 */
public class BitString {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 17));  // 8
        System.out.println(solution(2, 21, 25)); // 4
    }

    public static int solution(int n, long l, long r) {
        int answer = 0;

        for (long i = l - 1; i <= r - 1; i++) {
            long num = i;
            long div = (long) Math.pow(5, n - 1);
            while (div > 1) {
                if (num / div == 2) {
                    break;
                }
                num = num % div;
                div /= 5;
            }

            if (div == 1 && num != 2) answer++;
        }

        return answer;
    }
}
