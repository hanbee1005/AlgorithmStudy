import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(calculateSugarCount(n, n / 5));

    }

    private static int calculateSugarCount(int n, int fiveCount) {
        int answer = -1;

        int threeCount = 0;
        while (true) {
            if (n < (fiveCount * 5) + (threeCount * 3)) {
                break;
            }

            if (n == (fiveCount * 5) + (threeCount * 3)) {
                answer = fiveCount + threeCount;
                break;
            }

            threeCount++;
        }

        if (fiveCount != 0 && answer == -1) {
            answer = calculateSugarCount(n, fiveCount - 1);
        }

        return answer;
    }
}
