public class AnticipatedMatch {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    private static int solution(int n, int a, int b)
    {
        int answer = 0;

        while (true) {
            answer++;

            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double) b / 2);

            if (a == b || a == 0 || b == 0) {
                break;
            }
        }

        return answer;
    }
}
