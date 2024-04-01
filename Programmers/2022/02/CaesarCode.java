package Feb2022;

public class CaesarCode {
    public static void main(String[] args) {
        System.out.println(solution("z ", 1));
    }

    private static String solution(String s, int n) {
        return s.chars()
                .map(c -> {
                    if (c == ' ') return c;

                    int tmp = c + n;

                    // 대문자인 경우
                    if (c >= 'A' && c <= 'Z') {
                        if (tmp > 90) return 'A' + (tmp - 91);
                    } else {  // 소문자인 경우
                        if (tmp > 122) return 'a' + (tmp - 123);
                    }

                    return (char) tmp;
                })
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
