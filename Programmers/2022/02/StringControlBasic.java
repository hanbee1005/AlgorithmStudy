package Feb2022;

public class StringControlBasic {
    public static void main(String[] args) {
        System.out.println(solution("1234"));
    }

    private static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;

        long count = s.chars().filter(c -> !Character.isDigit(c)).count();

        return count == 0;
    }
}
