package Feb2022;

public class CheckSquareRoot {
    public static void main(String[] args) {
        System.out.println(solution(121));
    }

    private static long solution(long n) {
        long answer = -1;

        long i = 1;
        while (i * i < n) {
            i++;
        }

        if (i * i == n) answer = (long) Math.pow(i+1, 2);

        return answer;
    }
}
