package Feb2022;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(solution(987));
    }

    private static int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
