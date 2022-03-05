package Mar2022;

public class FibonacciNum {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    private static int solution(int n) {
        int answer = 0;
        int num1 = 1, num2 = 1;

        for (int i = 3; i <= n; i++) {
            answer = (num1 + num2) % 1234567;
            num1 = num2;
            num2 = answer;
        }

        return answer;
    }
}
