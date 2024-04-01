package Feb2022;

public class StringDecs {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    private static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        s.chars()
                .sorted()
                .forEach(c -> answer.insert(0, (char) c));

        return answer.toString();
    }
}
