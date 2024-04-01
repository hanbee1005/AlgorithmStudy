package Feb2022;

public class SumBetweenTwoInt {
    public static void main(String[] args) {
        System.out.println(solution(3, 5));
    }

    private static long solution(int a, int b) {
        long answer = 0;

        int s = Math.min(a, b);
        int e = Math.max(a, b);

        for (int i = s; i <= e; i++) {
            answer += i;
        }
        return answer;
    }
}
