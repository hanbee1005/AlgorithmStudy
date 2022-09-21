package Sep2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int realTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            int price = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);

            realTotal += price * count;
        }

        System.out.println((total == realTotal) ? "Yes" : "No");
    }
}
