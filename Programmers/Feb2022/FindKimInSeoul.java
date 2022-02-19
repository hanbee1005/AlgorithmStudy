package Feb2022;

public class FindKimInSeoul {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }

    private static String solution(String[] seoul) {
        StringBuilder answer = new StringBuilder("김서방은 ");

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer.append(i).append("에 있다");
                break;
            }
        }

        return answer.toString();
    }
}
