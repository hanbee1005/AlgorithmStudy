package Dec2021;

public class JumpAndMove {
    public static void main(String[] args) {
        System.out.println(solution(2500));
    }

    private static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 1) ans++;
            n /= 2;
        }

        return ans;
    }
}