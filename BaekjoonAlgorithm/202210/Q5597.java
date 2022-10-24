package Oct2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] students = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int idx = Integer.parseInt(br.readLine());
            students[idx] = true;
        }

        String result = "";

        for (int i = 1; i < 31; i++) {
            if (!students[i]) {
                result += (i + "\n");
            }
        }

        System.out.println(result);
    }
}
