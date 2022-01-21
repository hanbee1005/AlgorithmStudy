package Jan2022;

public class ExpressNumber {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    private static int solution(int n) {
        int answer = 1;

        int start = 1;

        while(start < n) {
            int sum = 0;

            for (int i = start; i <= (n / 2) + 1; i++) {
                sum += i;

                if (sum >= n) {
                    if (sum == n) answer++;
                    break;
                }
            }

            start++;
        }

        return answer;
    }
}
