import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            System.out.println(getResident(a, b));
        }
    }

    private static int getResident(int k, int n) {
        if (k == 0 || n == 1) {
            return n;
        }

        return getResident(k, n - 1) + getResident(k - 1, n);
    }
}
