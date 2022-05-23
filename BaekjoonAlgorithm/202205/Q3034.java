package May2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2)) >= n) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }

        System.out.println(sb);
    }
}
