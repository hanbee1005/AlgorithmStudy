package Feb2022;

public class SubakSubak {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    private static String solution(int n) {
        StringBuilder answer = new StringBuilder();

        String[] subak = new String[]{"수", "박"};

        for (int i = 0; i < n; i++) {
            answer.append(subak[i%2]);
        }

        return answer.toString();
    }
}
