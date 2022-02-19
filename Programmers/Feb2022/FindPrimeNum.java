package Feb2022;

public class FindPrimeNum {
    public static void main(String[] args) {
        System.out.println(solution(1000000));
    }

    private static int solution(int n) {
        int answer = 0;

        // 소수가 아닌 경우 true
        // 소수는 false
        boolean[] isPrime = new boolean[n+1];
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= n; i++) {
            // 소수인 경우
            if (!isPrime[i]) {
                answer++;
                for (int j = i; j <= n; j+=i) isPrime[j] = true;  // 배수들을 소수가 아닌 것으로 변경
            }
        }

        return answer;
    }
}
