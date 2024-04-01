package Feb2022;

public class GetCenterWord {
    public static void main(String[] args) {
        System.out.println(solution("abcde"));
    }

    private static String solution(String s) {
        String answer = "";

        int mid = s.length() / 2;
        boolean isEvenNum = s.length() % 2 == 0;

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(mid));
        if (isEvenNum) sb.insert(0, s.charAt(mid-1));

        answer = sb.toString();

        return answer;
    }
}
