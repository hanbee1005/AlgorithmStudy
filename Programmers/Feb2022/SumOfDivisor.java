package Feb2022;

public class SumOfDivisor {
    public static void main(String[] args) {
        System.out.println(solution(12));
    }
    private static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n%i == 0) answer += i;
        }

        return answer;
    }
}
