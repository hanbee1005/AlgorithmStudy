package Mar2022;

public class JadenCase {
    public static void main(String[] args) {
        System.out.println(solution("3people  unFollowed me"));
    }

    private static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        boolean isFirst = true;

        for (Character c : s.toCharArray()) {

            if (' ' == c) {
                answer.append(c);
                isFirst = true;
                continue;
            }

            if (isFirst) answer.append(String.valueOf(c).toUpperCase());
            else answer.append(String.valueOf(c).toLowerCase());

            isFirst = false;
        }

        return answer.toString();
    }
}
