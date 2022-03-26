package Mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231 {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i < num; i++) {
            int n = i;
            int sum = n;

            while(n != 0) {
                sum += n % 10;
                n /= 10;
            }

            if (num == sum) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
