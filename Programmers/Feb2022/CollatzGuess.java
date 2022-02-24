package Feb2022;

public class CollatzGuess {
    public static void main(String[] args) {
        System.out.println(solution(626331));
    }

    private static int solution(int num) {
        int answer = 0;

        long n = num;
        while (n != 1 && answer < 500) {
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
            answer++;
        }

        return answer >= 500 ? -1 : answer;
    }
}
