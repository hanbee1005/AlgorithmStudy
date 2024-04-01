package Feb2022;

public class MakeAWeirdText {
    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }

    private static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                idx = 0;
                continue;
            }

            if (idx%2 == 0) answer.append(String.valueOf(c).toUpperCase());
            else answer.append(String.valueOf(c).toLowerCase());

            idx++;
        }

        return answer.toString();
    }
}
