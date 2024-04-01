package Feb2022;

public class NumberOfDivisorAndAdd {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }

    private static int solution(int left, int right) {
        int answer = 0;

        for (int n = left; n <= right; n++) {
            int divisor = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) divisor++;
            }

            if (divisor % 2 == 0) answer += n;
            else answer -= n;
        }
        return answer;
    }
}
