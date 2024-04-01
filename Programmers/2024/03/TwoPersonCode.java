package Mar2024;

/**
 * Level 1. 둘만의 암호
 */
public class TwoPersonCode {
    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }

    private static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }
}
