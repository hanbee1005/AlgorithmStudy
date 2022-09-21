package Sep2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3003 {
    private static final int[] piece = new int[]{1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < piece.length; i++) {
            sb.append(piece[i] - input[i]).append(" ");
        }

        System.out.println(sb);
    }
}
