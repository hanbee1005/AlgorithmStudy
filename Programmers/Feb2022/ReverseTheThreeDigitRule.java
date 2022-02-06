package Feb2022;

public class ReverseTheThreeDigitRule {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }

    private static int solution(int n) {
        StringBuilder sb = new StringBuilder();

        // 3진법으로 변환 -> 뒤집기
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        // 10진법으로 변환
        int answer = Integer.parseInt(sb.toString(), 3);
        return answer;
    }
}
