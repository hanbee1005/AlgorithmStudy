package Feb2022;

public class CalcInsufficientAmount {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    private static long solution(int price, int money, int count) {
        long answer = -1;

        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += (long) price * i;
        }

        answer = money - sum < 0 ? sum - money : 0;

        return answer;
    }
}
